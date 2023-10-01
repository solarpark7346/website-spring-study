package com.develop.web.common.view.service;

import com.develop.web.common.view.dto.AccountDto;
import com.develop.web.domain.users.user.service.UserDetailFetcherService;
import com.develop.web.domain.users.user.service.UserListFetcherService;
import com.develop.web.domain.admin.rank.service.RankListFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Component("rankPageFetcher")
public class RankPageFetcher implements PageFetcher {
    private final UserDetailFetcherService userDetailFetcherService;
    private final UserListFetcherService userListFetcherService;
    private final RankListFetcher rankListFetcher;

    @Override
    public void fetchPage(AccountDto accountDto, Model model) {
        String account = accountDto.getAccount();

        model.addAttribute("UserList", userListFetcherService.findUsers());
        model.addAttribute("MemberInfo", userDetailFetcherService.findMember(account));
        model.addAttribute("RankList", rankListFetcher.getRankList());
    }
}
