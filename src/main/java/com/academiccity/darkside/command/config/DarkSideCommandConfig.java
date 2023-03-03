package com.academiccity.darkside.command.config;

import com.academiccity.darkside.command.infrustructure.repository.CommandFileReader;
import com.academiccity.darkside.command.infrustructure.repository.DefaultCommandFileReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jianbo
 * @Date 2023/2/3 14:33
 * @Version 1.0
 * @Description <br/>
 *
 */
@Configuration
public class DarkSideCommandConfig {
    @Bean
    public CommandFileReader commandFileReader() {
        return new DefaultCommandFileReader();
    }
}
