package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.IdsParams;
import info.jiaying.back_end.model.Ids;

public interface IdsService {
    void update(IdsParams idsParams);

    Ids get(int idsId);

    Object getAll();
}
