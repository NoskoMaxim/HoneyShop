package honeyshop.adapter.blankhoney;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.model.blankhoney.BlankHoney;

import java.util.ArrayList;
import java.util.List;

public class BlankHoneyAdapterImpl implements BlankHoneyAdapter {

    @Override
    public BlankHoney getBlankHoney(BlankHoneyDto blankHoneyDto) {
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setName(blankHoneyDto.getName());
        blankHoney.setDescription(blankHoneyDto.getDescription());
        blankHoney.setPrice(blankHoneyDto.getPrice());
        blankHoney.setPhotoUrl(blankHoneyDto.getPhotoUrl());
        return blankHoney;
    }

    @Override
    public List<BlankHoneyDto> getBlankHoneyDtoList(List<BlankHoney> blanksHoney) {
        List<BlankHoneyDto> blanksHoneyDto = new ArrayList<>();
        blanksHoney.forEach(blankHoney ->
                blanksHoneyDto.add(getBlankHoneyDto(blankHoney)));
        return blanksHoneyDto;
    }

    @Override
    public BlankHoneyDto getBlankHoneyDto(BlankHoney blankHoney) {
        BlankHoneyDto blankHoneyDto = new BlankHoneyDto();
        blankHoneyDto.setBlankHoneyId(blankHoney.getBlankHoneyId());
        blankHoneyDto.setName(blankHoney.getName());
        blankHoneyDto.setDescription(blankHoney.getDescription());
        blankHoneyDto.setPrice(blankHoney.getPrice());
        blankHoneyDto.setPhotoUrl(blankHoney.getPhotoUrl());
        return blankHoneyDto;
    }
}
