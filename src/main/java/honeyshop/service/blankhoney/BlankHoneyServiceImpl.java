package honeyshop.service.blankhoney;

import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;
import honeyshop.repository.section.BlankHoneyRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class BlankHoneyServiceImpl implements BlankHoneyService {

    private final BlankHoneyRepos blankHoneyRepos;

    @Autowired
    public BlankHoneyServiceImpl(BlankHoneyRepos blankHoneyRepos) {
        this.blankHoneyRepos = blankHoneyRepos;
    }

    @Override
    public void addBlankHoney(BlankHoneyDto blankHoneyDto) {
        BlankHoney blankHoney = new BlankHoney();
        initBlankHoney(blankHoneyDto, blankHoney);
        try {
            blankHoneyRepos.save(blankHoney);
        }catch (DataIntegrityViolationException psqlException){
            Map<String, String> failures = new HashMap<>();
            failures.put("BlankHoneyNameException", "Blank honey name already exists");
            throw new HoneyShopException(failures);
        }
    }

    @Override
    public void updateBlankHoney(BlankHoneyDto blankHoneyDto) {
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setBlankHoneyId(blankHoneyDto.getBlankHoneyId());
        initBlankHoney(blankHoneyDto, blankHoney);
        blankHoneyRepos.save(blankHoney);
    }

    @Override
    public void deleteBlankHoney(Long blankHoneyId) {
        blankHoneyRepos.deleteById(blankHoneyId);
    }

    public void initBlankHoney(BlankHoneyDto blankHoneyDto, BlankHoney blankHoney) {
        blankHoney.setName(blankHoneyDto.getName());
        blankHoney.setDescription(blankHoneyDto.getDescription());
        blankHoney.setPrice(blankHoneyDto.getPrice());
        blankHoney.setPhotoUrl(blankHoneyDto.getPhotoUrl());
    }
}
