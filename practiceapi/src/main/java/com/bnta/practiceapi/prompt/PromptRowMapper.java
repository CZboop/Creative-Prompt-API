package com.bnta.practiceapi.prompt;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromptRowMapper implements RowMapper<Prompt> {

    @Override
    public Prompt mapRow(ResultSet rs, int rowNum) throws SQLException {
        Prompt prompt =  new Prompt(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("discipline"),
                rs.getString("info"),
                rs.getInt("minsToComplete"),
                rs.getInt("difficulty"));
        return prompt;
    }

}
