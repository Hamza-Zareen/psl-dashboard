package io.hamzaprojs.psldashboard.data;

import io.hamzaprojs.psldashboard.Model.Match;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

        private final String[] Field_Names= new String[]{
                "id","city","date","venue","neutral_venue","team1","team2","toss_winner","toss_decision","winner","result","result_margin","eliminator","method","umpire1","umpire2"
        };

        @Autowired
        public JobBuilderFactory jobBuilderFactory;

        @Autowired
        public StepBuilderFactory stepBuilderFactory;

        @Bean
        public FlatFileItemReader<MatchInput> reader() {
                return new FlatFileItemReaderBuilder<MatchInput>()
                        .name("MatchItemReader")
                        .resource(new ClassPathResource("psl.csv"))
                        .delimited()
                        .names(Field_Names)
                        .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                                setTargetType(MatchInput.class);
                        }})
                        .build();
        }

        @Bean
        public MatchDataProcessor processor() {
                return new MatchDataProcessor();
        }

        @Bean
        public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
                return new JdbcBatchItemWriterBuilder<Match>()
                        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                        .sql("INSERT INTO match (id, city, date, venue, team1, team2, toss_winner, toss_decision, match_winner, result, result_margin, umpire1, umpire2) " +
                                "VALUES (:id, :city, :date, :venue, :team1, :team2, :tossWinner, :tossDecision, :matchWinner, :result, :resultMargin, :umpire1, :umpire2)")
                        .dataSource(dataSource)
                        .build();
        }

        @Bean
        public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
                return jobBuilderFactory.get("importUserJob")
                        .incrementer(new RunIdIncrementer())
                        .listener(listener)
                        .flow(step1)
                        .end()
                        .build();
        }

        @Bean
        public Step step1(JdbcBatchItemWriter<Match> writer) {
                return stepBuilderFactory.get("step1")
                        .<MatchInput, Match> chunk(10)
                        .reader(reader())
                        .processor(processor())
                        .writer(writer)
                        .build();
        }
}