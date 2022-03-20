package honeyshop.service.blankhoney;

import honeyshop.adapter.blankhoney.BlankHoneyAdapter;
import honeyshop.config.exception.honeyshopexception.SectionNameExistenceException;
import honeyshop.config.exception.honeyshopexception.SectionNotFoundException;
import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;
import honeyshop.repository.section.BlankHoneyRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

import static org.springframework.http.HttpStatus.GONE;

@Service
@Transactional
public class BlankHoneyServiceImpl implements BlankHoneyService {

    private final BlankHoneyRepos blankHoneyRepos;
    private final BlankHoneyAdapter blankHoneyAdapter;

    @Autowired
    public BlankHoneyServiceImpl(BlankHoneyRepos blankHoneyRepos, BlankHoneyAdapter blankHoneyAdapter) {
        this.blankHoneyRepos = blankHoneyRepos;
        this.blankHoneyAdapter = blankHoneyAdapter;
    }

    @Override
    public void addBlankHoney(BlankHoneyDto blankHoneyDto) {
        BlankHoney blankHoney = blankHoneyAdapter.getBlankHoney(blankHoneyDto);
        try {
            blankHoneyRepos.save(blankHoney);
        } catch (DataIntegrityViolationException psqlException) {
            throw new SectionNameExistenceException(new HashMap<>() {{
                put("SectionNameExistenceException",
                        "Blank honey name: " + blankHoney.getName() + " already exists");
            }});
        }
    }

    @Override
    public void updateBlankHoney(BlankHoneyDto blankHoneyDto) {
        BlankHoney blankHoney = blankHoneyAdapter.getBlankHoney(blankHoneyDto);
        blankHoneyRepos.save(blankHoney);
    }

    @Override
    public void deleteBlankHoney(Long blankHoneyId) {
        try {
            blankHoneyRepos.deleteById(blankHoneyId);
        } catch (EmptyResultDataAccessException psqlException) {
            throw new SectionNotFoundException(new HashMap<>() {{
                put("SectionNotFoundException",
                        "Blank honey with ID: " + blankHoneyId + " does not exist");
            }}, GONE);
        }
    }
}
