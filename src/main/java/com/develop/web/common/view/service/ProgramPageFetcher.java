package com.develop.web.common.view.service;

import com.develop.web.common.view.dto.AccountDto;
import com.develop.web.domain.admin.program.service.ProgramRecursionListFetcherService;
import com.develop.web.domain.admin.program.service.ProgramTypeFetcherService;
import com.develop.web.domain.users.user.service.UserDetailFetcherService;
import com.develop.web.domain.users.user.service.UserListFetcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Component("ProgramPageFetcher")
public class ProgramPageFetcher implements PageFetcher {
    private final UserDetailFetcherService userDetailFetcherService;
    private final UserListFetcherService userListFetcherService;
    private final ProgramRecursionListFetcherService programRecursionListFetcherService;
    private final ProgramTypeFetcherService programTypeFetcherService;

    @Override
    public void fetchPage(AccountDto accountDto, Model model) {
        String account = accountDto.getAccount();

        model.addAttribute("UserList", userListFetcherService.findUsers());
        model.addAttribute("MemberInfo", userDetailFetcherService.findMember(account));
        model.addAttribute("Program", programRecursionListFetcherService.findProgramList());
        model.addAttribute("ProgramType", programTypeFetcherService.findProgramTypeList());
    }
}
