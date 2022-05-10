package com.solvd.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@RequestTemplatePath(path = "api/todos/get/rs.json")
@Endpoint(methodType = HttpMethodType.GET, url = "https://jsonplaceholder.typicode.com/todos/1")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetTodoMethod extends AbstractApiMethodV2 {

    public GetTodoMethod() {
        super();
    }
}