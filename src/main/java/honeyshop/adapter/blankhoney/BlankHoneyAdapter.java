package honeyshop.adapter.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlankHoneyAdapter {
    ModelMapper blankHoneyMapper = new ModelMapper();

    public BlankHoney getBlankHoney(BlankHoneyDto blankHoneyDto){
        return blankHoneyMapper.map(blankHoneyDto, BlankHoney.class);
    }

    public BlankHoneyDto getBlankHoneyDto(BlankHoney blankHoney) {
        return blankHoneyMapper.map(blankHoney, BlankHoneyDto.class);
    }

    public List<BlankHoneyDto> getBlankHoneyDtoList(List<BlankHoney> blanksHoney) {
        return blanksHoney.stream()
                .map(this::getBlankHoneyDto)
                .collect(Collectors.toList());
    }
}
