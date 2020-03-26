package com.scoder.hs.controllers;

import org.springframework.web.bind.annotation.*;
@RestController
public class AjaxRestController {

    @RequestMapping(value = "/chart1", method = RequestMethod.POST)
    public String chart1() {
        String addr = "http://openapi.kab.co.kr/OpenAPI_ToolInstallPackage/service/rest/RealTradingPriceIndexSvc/getAptRealTradingPriceIndexSize?serviceKey=";
        String serviceKey = "j0Onh%2BsTbXxrSPgnbJpJ%2Fc1RsY1YHd%2B0%2FKnCwWH3mVdQyTADwTk495K6pnl%2BfzKTak1pISmN0cx31BgMPmxWjg%3D%3D";
        String parameter = "";
        String parameter2 = "";
        parameter = parameter + "&" + "startmonth=201901";
        parameter = parameter + "&" + "endmonth=201908";
        parameter = parameter + "&" + "region=11000";
        parameter = parameter + "&" + "contractType=0";
        String temp = addr +  serviceKey + parameter;
        System.out.println(temp);
//        URL url = new URL(addr);
        return "왜이래";
    }
}

