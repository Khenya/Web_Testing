package api.factory;

import io.restassured.response.Response;

public interface IRequest {
    Response send(RequestInfo requestInfo);
}