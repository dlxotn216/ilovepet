/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-23
 */
package sch.pl.graduate.recommendation.code.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.code.mapper.CodeMapper;
import sch.pl.graduate.recommendation.code.model.Code;
import sch.pl.graduate.recommendation.code.model.CodeCriteria;
import sch.pl.graduate.recommendation.code.service.CodeService;
import sch.pl.graduate.recommendation.pet.model.PetType;
import sch.pl.graduate.recommendation.user.common.model.CityType;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-23.
 */
@Service
public class CodeServiceImpl implements CodeService{

    @Autowired
    private CodeMapper codeMapper;

    @Override
    public List<PetType> getPetTypes(CodeCriteria codeCriteria) {
        return codeMapper.getPetTypes(codeCriteria);
    }

    @Override
    public List<CityType> getCityTypes(CodeCriteria codeCriteria) {
        return codeMapper.getCityTypes(codeCriteria);
    }

    @Override
    public Integer addCode(Code code) {
        return codeMapper.addCode(code);
    }

    @Override
    public List<Code> getCodes(CodeCriteria codeCriteria) {
        return codeMapper.getCodes(codeCriteria);
    }

    @Override
    public Integer getCodesTotalCount(CodeCriteria codeCriteria) {
        return codeMapper.getCodesTotalCount(codeCriteria);
    }

    @Override
    public Code getCodeByCodeKey(Long codeKey) {
        return codeMapper.getCodeByCodeKey(codeKey);
    }

    @Override
    public Integer updateCode(Code code) {
        return codeMapper.updateCode(code);
    }

    @Override
    public Integer deleteCode(Code code) {
        return codeMapper.deleteCode(code);
    }
}
