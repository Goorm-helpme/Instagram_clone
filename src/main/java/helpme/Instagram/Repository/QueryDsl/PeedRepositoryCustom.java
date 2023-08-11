package helpme.Instagram.Repository.QueryDsl;

import helpme.Instagram.Domain.Peed;

import java.util.List;

public interface PeedRepositoryCustom {
    List<Peed> findById_Query(Long id);
}
