package org.anson.miniproduct.domainservice.internal.userrole;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
public interface IUserRoleDMService {
    void addByUser(@Valid @NotBlank String userId, @Valid @NotNull Collection<String> roleIds);
    void addByRole(@Valid @NotBlank String roleId, @Valid @NotNull Collection<String> userIds);
    void deleteByUser(@Valid @NotBlank String userId, Collection<String> roleIds) throws Exception;
    void deleteByRole(@Valid @NotBlank String roleId, Collection<String> userIds) throws Exception;
}
