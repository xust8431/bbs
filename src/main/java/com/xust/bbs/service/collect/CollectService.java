package com.xust.bbs.service.collect;



import java.util.List;

import com.xust.bbs.entity.Collect;
import com.xust.bbs.util.BBSResult;

public interface CollectService {

	public BBSResult<Collect> collectPost(String postId, String userName);
	public BBSResult<List<Collect>> findCollectList(String userName, int offset);
}
