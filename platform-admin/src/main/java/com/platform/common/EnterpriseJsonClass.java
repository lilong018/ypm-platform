package com.platform.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName EnterpriseJsonClass
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/31 10:40
 * @Version 1.0
 **/
@NoArgsConstructor
@Data
public class EnterpriseJsonClass {

    /**
     * payload : {"results":[{"account":"15554800006","channels":[{"banks":{"5f978be26c1b722008acd6ac":{"accountName":"山东一汽有限公司","accountNumber":"1500010056849","applyStatus":1,"applyStatusHistory":{"1603767266624":{"applyStatus":1,"time":1603767266624}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"","comment":"","createTimeInMillis":1603767266624,"entId":"5f978bb06c1b722008acd6aa","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"15554800006@163.com","handlerId":"371311198605152456","handlerName":"张三","handlerPhoneNo":"15554800006","name":"平安银行股份有限公司北京分行","number":"307100003019","occBankChildCode":"PAB","occBankChildName":"平安","occBankCnap":"307100003019","occBankCode":"307","occBankName":"平安银行股份有限公司北京分行","provinceId":"370","provinceName":"","source":1,"type":1}},"entRole":2,"type":1,"validEnt":0}],"companyInfo":{"address":"经营地址","businessExpirationDate":"2024-10-31","businessLicenseUrl":"images/enterprises/5f978bb06c1b722008acd6aa/businessLicense.jpg","city":"4730","idcardExpirationDate":"2028-10-28","legalRepId":"371311198605152456","legalRepIdPicBackUrl":"images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"15554800006","name":"山东一汽有限公司","province":"370","regAddress":"注册地址","regArea":"371302","regCity":"371300","regProvince":"370000","uscc":"913713006974865M52"},"id":"5f978bb06c1b722008acd6aa","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"15554800005","channels":[],"companyInfo":{"address":"山东新世纪有限公司经营地址","businessExpirationDate":"2022-10-21","businessLicenseUrl":"images/enterprises/5f9696776c1b722008acd6a5/businessLicense.jpg","city":"4730","idcardExpirationDate":"2024-10-19","legalRepId":"371311188801265456","legalRepIdPicBackUrl":"images/enterprises/5f9696776c1b722008acd6a5/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f9696776c1b722008acd6a5/legalRepIdFront.jpg","legalRepName":"李四","legalRepPhoneNo":"15554800005","name":"山东新世纪有限公司","province":"370","regAddress":"山东新世纪有限公司注册地址","regArea":"371302","regCity":"371300","regProvince":"370000","uscc":"91371300334486754O"},"id":"5f9696776c1b722008acd6a5","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"15554800003","channels":[],"companyInfo":{"address":"经营地址","businessExpirationDate":"2021-10-22","businessLicenseUrl":"images/enterprises/5f9681ee6c1b722008acd69c/businessLicense.jpg","city":"2900","idcardExpirationDate":"2023-10-20","legalRepId":"371311186802154568","legalRepIdPicBackUrl":"images/enterprises/5f9681ee6c1b722008acd69c/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f9681ee6c1b722008acd69c/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"15554800003","name":"北京新天地有限公司","province":"310","regAddress":"注册地址","regArea":"310113","regCity":"310100","regProvince":"310000","uscc":"91371300658986985L"},"id":"5f9681ee6c1b722008acd69c","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"18648686689","channels":[{"banks":{"5f784ac66c1b7253b0862cf9":{"accountName":"山东油菜花有限公司","accountNumber":"1500010045876","applyStatus":3,"applyStatusHistory":{"1601718982254":{"applyStatus":1,"time":1601718982254},"1601722111328":{"applyStatus":3,"time":1601722111328}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelInfo":{"jrApplyId":"23454578392","partnerApplyId":"20f0b546158847d284c66e57a5c6023c"},"channelType":1,"cityId":"4730","cityName":"临沂市","comment":"","createTimeInMillis":1601718982254,"entId":"5f784aaa6c1b7253b0862cf6","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"sdj221231312@163.com","handlerId":"371311198602152666","handlerName":"张三","handlerPhoneNo":"18648686689","name":"平安银行","number":"1500010045876","occBankChildCode":"307473000019","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}},"entRole":1,"type":1,"validEnt":0}],"companyInfo":{"accountOpeningLicenseUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/accountOpeningLicense.jpg","address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","businessLicenseUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/businessLicense.jpg","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152666","legalRepIdPicBackUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"18648686689","name":"山东油菜花有限公司","province":"山东省","uscc":"91371300334488969P"},"id":"5f784aaa6c1b7253b0862cf6","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"18865458565","channels":[{"banks":{"5f7734776c1b7253b0862ceb":{"accountName":"山东材积有限公司","accountNumber":"1500010014981","applyStatus":1,"applyStatusHistory":{"1601647735213":{"applyStatus":1,"time":1601647735213}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"临沂市","comment":"","createTimeInMillis":1601647735213,"entId":"5f77344b6c1b7253b0862ce8","handler":{"id":"","name":""},"handlerEmail":"sdj221@163.com","handlerId":"371311198602152968","handlerName":"张三","handlerPhoneNo":"18648654689","name":"平安银行","number":"1500010014981","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}},"entRole":1,"type":1,"validEnt":0}],"companyInfo":{"accountOpeningLicenseUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/accountOpeningLicense.jpg","address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","businessLicenseUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/businessLicense.jpg","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152968","legalRepIdPicBackUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"18769898589","name":"山东材积有限公司","province":"山东省","uscc":"91371300334486989P"},"id":"5f77344b6c1b7253b0862ce8","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"18754215658","channels":[],"companyInfo":{"address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152589","legalRepName":"张三","legalRepPhoneNo":"18769898589","name":"山东参团有限公司","province":"山东省","uscc":"91371300334488659P"},"id":"5f76a7906c1b7253b0862ce1","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"15554807565","channels":[{"banks":{"5f6ef99c6c1b7253b0862cd1":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"临沂市","comment":"","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}},"entRole":1,"type":1,"validEnt":0}],"companyInfo":{"accountOpeningLicenseUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/accountOpeningLicense.jpg","address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","businessLicenseUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/businessLicense.jpg","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152548","legalRepIdPicBackUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/legalRepIdFront.jpg","legalRepName":"张杰","legalRepPhoneNo":"18769898545","name":"临沂兴鲁商贸有限公司","province":"山东省","uscc":"91371300334486869D"},"id":"5f6ef99b6c1b7253b0862cce","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}}],"size":7,"total":7}
     * statusCode : 0
     */

    private PayloadBean payload;
    private int statusCode;

    @NoArgsConstructor
    @Data
    public static class PayloadBean  {
        /**
         * results : [{"account":"15554800006","channels":[{"banks":{"5f978be26c1b722008acd6ac":{"accountName":"山东一汽有限公司","accountNumber":"1500010056849","applyStatus":1,"applyStatusHistory":{"1603767266624":{"applyStatus":1,"time":1603767266624}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"","comment":"","createTimeInMillis":1603767266624,"entId":"5f978bb06c1b722008acd6aa","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"15554800006@163.com","handlerId":"371311198605152456","handlerName":"张三","handlerPhoneNo":"15554800006","name":"平安银行股份有限公司北京分行","number":"307100003019","occBankChildCode":"PAB","occBankChildName":"平安","occBankCnap":"307100003019","occBankCode":"307","occBankName":"平安银行股份有限公司北京分行","provinceId":"370","provinceName":"","source":1,"type":1}},"entRole":2,"type":1,"validEnt":0}],"companyInfo":{"address":"经营地址","businessExpirationDate":"2024-10-31","businessLicenseUrl":"images/enterprises/5f978bb06c1b722008acd6aa/businessLicense.jpg","city":"4730","idcardExpirationDate":"2028-10-28","legalRepId":"371311198605152456","legalRepIdPicBackUrl":"images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"15554800006","name":"山东一汽有限公司","province":"370","regAddress":"注册地址","regArea":"371302","regCity":"371300","regProvince":"370000","uscc":"913713006974865M52"},"id":"5f978bb06c1b722008acd6aa","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"15554800005","channels":[],"companyInfo":{"address":"山东新世纪有限公司经营地址","businessExpirationDate":"2022-10-21","businessLicenseUrl":"images/enterprises/5f9696776c1b722008acd6a5/businessLicense.jpg","city":"4730","idcardExpirationDate":"2024-10-19","legalRepId":"371311188801265456","legalRepIdPicBackUrl":"images/enterprises/5f9696776c1b722008acd6a5/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f9696776c1b722008acd6a5/legalRepIdFront.jpg","legalRepName":"李四","legalRepPhoneNo":"15554800005","name":"山东新世纪有限公司","province":"370","regAddress":"山东新世纪有限公司注册地址","regArea":"371302","regCity":"371300","regProvince":"370000","uscc":"91371300334486754O"},"id":"5f9696776c1b722008acd6a5","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"15554800003","channels":[],"companyInfo":{"address":"经营地址","businessExpirationDate":"2021-10-22","businessLicenseUrl":"images/enterprises/5f9681ee6c1b722008acd69c/businessLicense.jpg","city":"2900","idcardExpirationDate":"2023-10-20","legalRepId":"371311186802154568","legalRepIdPicBackUrl":"images/enterprises/5f9681ee6c1b722008acd69c/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f9681ee6c1b722008acd69c/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"15554800003","name":"北京新天地有限公司","province":"310","regAddress":"注册地址","regArea":"310113","regCity":"310100","regProvince":"310000","uscc":"91371300658986985L"},"id":"5f9681ee6c1b722008acd69c","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"18648686689","channels":[{"banks":{"5f784ac66c1b7253b0862cf9":{"accountName":"山东油菜花有限公司","accountNumber":"1500010045876","applyStatus":3,"applyStatusHistory":{"1601718982254":{"applyStatus":1,"time":1601718982254},"1601722111328":{"applyStatus":3,"time":1601722111328}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelInfo":{"jrApplyId":"23454578392","partnerApplyId":"20f0b546158847d284c66e57a5c6023c"},"channelType":1,"cityId":"4730","cityName":"临沂市","comment":"","createTimeInMillis":1601718982254,"entId":"5f784aaa6c1b7253b0862cf6","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"sdj221231312@163.com","handlerId":"371311198602152666","handlerName":"张三","handlerPhoneNo":"18648686689","name":"平安银行","number":"1500010045876","occBankChildCode":"307473000019","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}},"entRole":1,"type":1,"validEnt":0}],"companyInfo":{"accountOpeningLicenseUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/accountOpeningLicense.jpg","address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","businessLicenseUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/businessLicense.jpg","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152666","legalRepIdPicBackUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f784aaa6c1b7253b0862cf6/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"18648686689","name":"山东油菜花有限公司","province":"山东省","uscc":"91371300334488969P"},"id":"5f784aaa6c1b7253b0862cf6","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"18865458565","channels":[{"banks":{"5f7734776c1b7253b0862ceb":{"accountName":"山东材积有限公司","accountNumber":"1500010014981","applyStatus":1,"applyStatusHistory":{"1601647735213":{"applyStatus":1,"time":1601647735213}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"临沂市","comment":"","createTimeInMillis":1601647735213,"entId":"5f77344b6c1b7253b0862ce8","handler":{"id":"","name":""},"handlerEmail":"sdj221@163.com","handlerId":"371311198602152968","handlerName":"张三","handlerPhoneNo":"18648654689","name":"平安银行","number":"1500010014981","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}},"entRole":1,"type":1,"validEnt":0}],"companyInfo":{"accountOpeningLicenseUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/accountOpeningLicense.jpg","address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","businessLicenseUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/businessLicense.jpg","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152968","legalRepIdPicBackUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f77344b6c1b7253b0862ce8/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"18769898589","name":"山东材积有限公司","province":"山东省","uscc":"91371300334486989P"},"id":"5f77344b6c1b7253b0862ce8","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"18754215658","channels":[],"companyInfo":{"address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152589","legalRepName":"张三","legalRepPhoneNo":"18769898589","name":"山东参团有限公司","province":"山东省","uscc":"91371300334488659P"},"id":"5f76a7906c1b7253b0862ce1","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}},{"account":"15554807565","channels":[{"banks":{"5f6ef99c6c1b7253b0862cd1":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"临沂市","comment":"","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}},"entRole":1,"type":1,"validEnt":0}],"companyInfo":{"accountOpeningLicenseUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/accountOpeningLicense.jpg","address":"山东省临沂市兰山区义堂镇小义堂社区","businessExpirationDate":"2025-03-19","businessLicenseUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/businessLicense.jpg","city":"临沂市","idcardExpirationDate":"2035-09-19","legalRepId":"371311198602152548","legalRepIdPicBackUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f6ef99b6c1b7253b0862cce/legalRepIdFront.jpg","legalRepName":"张杰","legalRepPhoneNo":"18769898545","name":"临沂兴鲁商贸有限公司","province":"山东省","uscc":"91371300334486869D"},"id":"5f6ef99b6c1b7253b0862cce","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"}}]
         * size : 7
         * total : 7
         */

        private int size;
        private int total;
        private List<ResultsBean> results;

        @NoArgsConstructor
        @Data
        public static class ResultsBean  {
            /**
             * account : 15554800006
             * channels : [{"banks":{"5f978be26c1b722008acd6ac":{"accountName":"山东一汽有限公司","accountNumber":"1500010056849","applyStatus":1,"applyStatusHistory":{"1603767266624":{"applyStatus":1,"time":1603767266624}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"","comment":"","createTimeInMillis":1603767266624,"entId":"5f978bb06c1b722008acd6aa","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"15554800006@163.com","handlerId":"371311198605152456","handlerName":"张三","handlerPhoneNo":"15554800006","name":"平安银行股份有限公司北京分行","number":"307100003019","occBankChildCode":"PAB","occBankChildName":"平安","occBankCnap":"307100003019","occBankCode":"307","occBankName":"平安银行股份有限公司北京分行","provinceId":"370","provinceName":"","source":1,"type":1}},"entRole":2,"type":1,"validEnt":0}]
             * companyInfo : {"address":"经营地址","businessExpirationDate":"2024-10-31","businessLicenseUrl":"images/enterprises/5f978bb06c1b722008acd6aa/businessLicense.jpg","city":"4730","idcardExpirationDate":"2028-10-28","legalRepId":"371311198605152456","legalRepIdPicBackUrl":"images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdBack.jpg","legalRepIdPicFrontUrl":"images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdFront.jpg","legalRepName":"张三","legalRepPhoneNo":"15554800006","name":"山东一汽有限公司","province":"370","regAddress":"注册地址","regArea":"371302","regCity":"371300","regProvince":"370000","uscc":"913713006974865M52"}
             * id : 5f978bb06c1b722008acd6aa
             * platform : {"id":"5f6eeb3d6c1b725440329883","name":"有票么"}
             */

            private String account;
            private CompanyInfoBean companyInfo;
            private String id;
            private PlatformBean platform;
            private List<ChannelsBean> channels;

            @NoArgsConstructor
            @Data
            public static class CompanyInfoBean  {
                /**
                 * address : 经营地址
                 * businessExpirationDate : 2024-10-31
                 * businessLicenseUrl : images/enterprises/5f978bb06c1b722008acd6aa/businessLicense.jpg
                 * city : 4730
                 * idcardExpirationDate : 2028-10-28
                 * legalRepId : 371311198605152456
                 * legalRepIdPicBackUrl : images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdBack.jpg
                 * legalRepIdPicFrontUrl : images/enterprises/5f978bb06c1b722008acd6aa/legalRepIdFront.jpg
                 * legalRepName : 张三
                 * legalRepPhoneNo : 15554800006
                 * name : 山东一汽有限公司
                 * province : 370
                 * regAddress : 注册地址
                 * regArea : 371302
                 * regCity : 371300
                 * regProvince : 370000
                 * uscc : 913713006974865M52
                 */

                private String address;
                private String businessExpirationDate;
                private String businessLicenseUrl;
                private String city;
                private String idcardExpirationDate;
                private String legalRepId;
                private String legalRepIdPicBackUrl;
                private String legalRepIdPicFrontUrl;
                private String legalRepName;
                private String legalRepPhoneNo;
                private String name;
                private String province;
                private String regAddress;
                private String regArea;
                private String regCity;
                private String regProvince;
                private String uscc;
            }

            @NoArgsConstructor
            @Data
            public static class PlatformBean  {
                /**
                 * id : 5f6eeb3d6c1b725440329883
                 * name : 有票么
                 */

                private String id;
                private String name;
            }

            @NoArgsConstructor
            @Data
            public static class ChannelsBean  {
                /**
                 * banks : {"5f978be26c1b722008acd6ac":{"accountName":"山东一汽有限公司","accountNumber":"1500010056849","applyStatus":1,"applyStatusHistory":{"1603767266624":{"applyStatus":1,"time":1603767266624}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"","comment":"","createTimeInMillis":1603767266624,"entId":"5f978bb06c1b722008acd6aa","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"15554800006@163.com","handlerId":"371311198605152456","handlerName":"张三","handlerPhoneNo":"15554800006","name":"平安银行股份有限公司北京分行","number":"307100003019","occBankChildCode":"PAB","occBankChildName":"平安","occBankCnap":"307100003019","occBankCode":"307","occBankName":"平安银行股份有限公司北京分行","provinceId":"370","provinceName":"","source":1,"type":1}}
                 * entRole : 2
                 * type : 1
                 * validEnt : 0
                 */

                private BanksBean banks;
                private int entRole;
                private int type;
                private int validEnt;

                @NoArgsConstructor
                @Data
                public static class BanksBean  {
                    /**
                     * 5f978be26c1b722008acd6ac : {"accountName":"山东一汽有限公司","accountNumber":"1500010056849","applyStatus":1,"applyStatusHistory":{"1603767266624":{"applyStatus":1,"time":1603767266624}},"auditResult":[{"comment":"","reason":[],"result":-1}],"channelType":1,"cityId":"4730","cityName":"","comment":"","createTimeInMillis":1603767266624,"entId":"5f978bb06c1b722008acd6aa","handler":{"id":"5f6ef1186c1b725440329897","name":"孙同春"},"handlerEmail":"15554800006@163.com","handlerId":"371311198605152456","handlerName":"张三","handlerPhoneNo":"15554800006","name":"平安银行股份有限公司北京分行","number":"307100003019","occBankChildCode":"PAB","occBankChildName":"平安","occBankCnap":"307100003019","occBankCode":"307","occBankName":"平安银行股份有限公司北京分行","provinceId":"370","provinceName":"","source":1,"type":1}
                     */

                    private _$5f978be26c1b722008acd6acBean _$5f978be26c1b722008acd6ac;

                    @NoArgsConstructor
                    @Data
                    public static class _$5f978be26c1b722008acd6acBean  {
                        /**
                         * accountName : 山东一汽有限公司
                         * accountNumber : 1500010056849
                         * applyStatus : 1
                         * applyStatusHistory : {"1603767266624":{"applyStatus":1,"time":1603767266624}}
                         * auditResult : [{"comment":"","reason":[],"result":-1}]
                         * channelType : 1
                         * cityId : 4730
                         * cityName : 
                         * comment : 
                         * createTimeInMillis : 1603767266624
                         * entId : 5f978bb06c1b722008acd6aa
                         * handler : {"id":"5f6ef1186c1b725440329897","name":"孙同春"}
                         * handlerEmail : 15554800006@163.com
                         * handlerId : 371311198605152456
                         * handlerName : 张三
                         * handlerPhoneNo : 15554800006
                         * name : 平安银行股份有限公司北京分行
                         * number : 307100003019
                         * occBankChildCode : PAB
                         * occBankChildName : 平安
                         * occBankCnap : 307100003019
                         * occBankCode : 307
                         * occBankName : 平安银行股份有限公司北京分行
                         * provinceId : 370
                         * provinceName : 
                         * source : 1
                         * type : 1
                         */

                        private String accountName;
                        private String accountNumber;
                        private int applyStatus;
                        private ApplyStatusHistoryBean applyStatusHistory;
                        private int channelType;
                        private String cityId;
                        private String cityName;
                        private String comment;
                        private long createTimeInMillis;
                        private String entId;
                        private HandlerBean handler;
                        private String handlerEmail;
                        private String handlerId;
                        private String handlerName;
                        private String handlerPhoneNo;
                        private String name;
                        private String number;
                        private String occBankChildCode;
                        private String occBankChildName;
                        private String occBankCnap;
                        private String occBankCode;
                        private String occBankName;
                        private String provinceId;
                        private String provinceName;
                        private int source;
                        private int type;
                        private List<AuditResultBean> auditResult;

                        @NoArgsConstructor
                        @Data
                        public static class ApplyStatusHistoryBean  {
                            /**
                             * 1603767266624 : {"applyStatus":1,"time":1603767266624}
                             */

                            private _$1603767266624Bean _$1603767266624;

                            @NoArgsConstructor
                            @Data
                            public static class _$1603767266624Bean  {
                                /**
                                 * applyStatus : 1
                                 * time : 1603767266624
                                 */

                                private int applyStatus;
                                private long time;
                            }
                        }

                        @NoArgsConstructor
                        @Data
                        public static class HandlerBean  {
                            /**
                             * id : 5f6ef1186c1b725440329897
                             * name : 孙同春
                             */

                            private String id;
                            private String name;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class AuditResultBean  {
                            /**
                             * comment : 
                             * reason : []
                             * result : -1
                             */

                            private String comment;
                            private int result;
                            private List<?> reason;
                        }
                    }
                }
            }
        }
    }
}
