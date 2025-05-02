package com.example.boardproject.application.service.impl;

import com.example.boardproject.application.model.repository.UserActiveLtRepository;
import com.example.boardproject.application.model.transfer.Request.AccountRegisterRequest;
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
    private final UserActiveLtRepository userActiveLtRepository;

    @Override
    @Transactional
    public boolean registerUser(AccountRegisterRequest memberRegistRequest){
        PreContionalUtil.valid(memberRegistRequest);

        if (memberRegistRequest.getIsDuplicate()){
            throw new CommonException(ErrorMessageType.DUPLICATE_PARAMETER);
        }
        return userActiveLtRepository.registerUser(memberRegistRequest);
    }

//    @Override
//    public AssociateUserResponse loginAssociate(UserDataDto userDataDto) {
//        return associateUtRepository.loginAssociate(userDataDto);
//    }


}
