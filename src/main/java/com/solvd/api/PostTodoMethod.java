package com.solvd.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;


@RequestTemplatePath(path = "api/todos/post/rq.json")
@ResponseTemplatePath(path = "api/todos/post/rs.json")
@Endpoint(methodType = HttpMethodType.POST, url = "https://jsonplaceholder.typicode.com/todos")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)

public class PostTodoMethod extends AbstractApiMethodV2 {

    public PostTodoMethod() {
        super();
        setProperties("api/todos/post/todos.properties");
    }
}
