package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.repository.AssociateUtRepository;
import com.example.boardproject.application.model.transfer.Dto.UserDataDto;
import com.example.boardproject.application.model.transfer.Request.MemberRegistRequest;
import com.example.boardproject.application.model.type.ErrorMessageType;
import com.example.boardproject.application.service.AssociateService;
import com.example.boardproject.application.util.CommonException;
import com.example.boardproject.application.util.PreContionalUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssociateServiceImpl implements AssociateService {
    private final AssociateUtRepository associateUtRepository;

    @Override
    @Transactional
    public boolean registerUser(MemberRegistRequest memberRegistRequest){
        PreContionalUtil.valid(memberRegistRequest);

        if (memberRegistRequest.getIsDuplicate()){
            throw new CommonException(ErrorMessageType.DUPLICATE_PARAMETER);
        }
        return associateUtRepository.registerUser(memberRegistRequest);
    }

//    @Override
//    public AssociateUserResponse loginAssociate(UserDataDto userDataDto) {
//        return associateUtRepository.loginAssociate(userDataDto);
//    }


}
