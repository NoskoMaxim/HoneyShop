package honeyshop.adapter.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;

import java.util.List;

public interface BlankHoneyAdapter {

    BlankHoney getBlankHoney(BlankHoneyDto blankHoneyDto);

    List<BlankHoneyDto> getBlankHoneyDtoList(List<BlankHoney> blanksHoney);

    BlankHoneyDto getBlankHoneyDto(BlankHoney blankHoney);
}
