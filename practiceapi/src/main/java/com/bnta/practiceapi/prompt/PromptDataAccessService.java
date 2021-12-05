package com.bnta.practiceapi.prompt;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("postgres")
public class PromptDataAccessService implements PromptDAO{
    private JdbcTemplate jdbcTemplate;

    public PromptDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Prompt> getAllPrompts() {
        String sql = """
                SELECT id, title, discipline, info, minsToComplete, difficulty FROM prompts;
                """;
        List<Prompt> prompts = jdbcTemplate.query(sql, new PromptRowMapper());
        return prompts;
    }


    public int addPrompt(Prompt prompt){
        String sql = "INSERT INTO prompts(title, discipline, info, minsToComplete, difficulty) " +
                "VALUES(?, ?, ?, ?, ?);";
        int NumberOfRowsAffected = jdbcTemplate.update(sql, prompt.getTitle(), prompt.getDiscipline(),
                prompt.getInfo(), prompt.getMinsToComplete(), prompt.getDifficulty());
        return NumberOfRowsAffected;
    }

    @Override
    public int deletePrompt(int id){
        String sql = "DELETE FROM prompts WHERE id = ?";
        int deleted = jdbcTemplate.update(sql, id);
            return deleted;
    }

    @Override
    public int updatePrompt(int id, Prompt prompt) {
        String sql = """
                UPDATE prompts SET title = ?, 
                discipline = ?,
                info = ?,
                minsToComplete = ?,
                difficulty = ?
                WHERE id = ?
                """;
        int updated = jdbcTemplate.update(sql, prompt.getTitle(), prompt.getDiscipline(),
                prompt.getInfo(), prompt.getMinsToComplete(), prompt.getDifficulty(), id);
        return updated;
    }
}
