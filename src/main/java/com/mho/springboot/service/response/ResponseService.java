package com.mho.springboot.service.response;

import com.mho.springboot.model.response.CommonResult;
import com.mho.springboot.model.response.ListResult;
import com.mho.springboot.model.response.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    public CommonResult geteFailResult(int code, String msg) {
        CommonResult result = new CommonResult();
        CommonResult.Error error = result.new Error(code, msg);
        result.setError(error);
        return result;
    }

    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
    }
}
