package honeyshop.service.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;
import honeyshop.repository.section.BlankHoneyRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlankHoneyService {

    private final BlankHoneyRepos blankHoneyRepos;

    @Autowired
    public BlankHoneyService(BlankHoneyRepos blankHoneyRepos) {
        this.blankHoneyRepos = blankHoneyRepos;
    }

    public void addBlankHoney(BlankHoneyDto blankHoneyDto) {
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setName(blankHoneyDto.getName());
        blankHoney.setDescription(blankHoneyDto.getDescription());
        blankHoney.setPrice(blankHoneyDto.getPrice());
        blankHoney.setPhotoUrl(blankHoneyDto.getPhotoUrl());
        blankHoneyRepos.save(blankHoney);
    }

    public void updatePublication(BlankHoneyDto blankHoneyDto) {
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setBlankHoneyId(blankHoneyDto.getBlankHoneyId());
        blankHoney.setName(blankHoneyDto.getName());
        blankHoney.setDescription(blankHoneyDto.getDescription());
        blankHoney.setPrice(blankHoneyDto.getPrice());
        blankHoney.setPhotoUrl(blankHoneyDto.getPhotoUrl());
        blankHoneyRepos.save(blankHoney);
    }

    public void deleteBlankHoney(Long blankHoneyId) {
        blankHoneyRepos.deleteById(blankHoneyId);
    }
}
