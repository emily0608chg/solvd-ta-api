package com.solvd.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@RequestTemplatePath(path = "api/todos/path/rq.json")
@ResponseTemplatePath(path = "api/todos/path/rs.json")
@Endpoint(methodType = HttpMethodType.PATCH, url = "https://jsonplaceholder.typicode.com/todos/${id}")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchTodoMethod extends AbstractApiMethodV2 {
    public PatchTodoMethod(int id) {
        super();
        replaceUrlPlaceholder("id", String.valueOf(1));
    }
}
