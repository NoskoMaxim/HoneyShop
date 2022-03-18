package honeyshop.service.blankhoney;

import honeyshop.adapter.blankhoney.BlankHoneyAdapter;
import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;
import honeyshop.repository.section.BlankHoneyRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
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
            Map<String, String> failures = new HashMap<>();
            failures.put("BlankHoneyNameException", "Blank honey name already exists");
            throw new HoneyShopException(failures, BAD_REQUEST);
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
            Map<String, String> failures = new HashMap<>();
            failures.put("NotFoundBlankHoneyException", "Blank honey does not exist");
            throw new HoneyShopException(failures, GONE);
        }
    }
}
