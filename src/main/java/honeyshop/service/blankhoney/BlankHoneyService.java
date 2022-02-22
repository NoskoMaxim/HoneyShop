package honeyshop.service.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;

public interface BlankHoneyService {
    void addBlankHoney(BlankHoneyDto blankHoneyDto);
    void updateBlankHoney(BlankHoneyDto blankHoneyDto);
    void deleteBlankHoney(Long blankHoneyId);
}
