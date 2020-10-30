package com.platform.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName JsonClass
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/30 9:50
 * @Version 1.0
 **/
@NoArgsConstructor
@Data
public class JsonClass {


    /**
     * payload : {"results":[{"auditResult":{"comment":"","reason":[],"result":-1},"bill":{"acceptingBankName":"华夏银行股份有限公司","acceptingBankNumber":"304241000028","acceptingBankType":1,"amount":5.0E7,"backPictures":{"0e85fef0ba5240178dc0e81f5e64a1b8":"images/bills/5f9a594c6c1b722008acd6df/backPicture_0e85fef0ba5240178dc0e81f5e64a1b8.jpg"},"channelType":1,"createTimeInMillis":1603950924786,"currentState":0,"customDefect":"","doubleEndorsementCount":0,"draweeName":"超市有限公司","drawerName":"房地产有限公司","dueDate":"2021-07-28","endorseBank":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2},"endorseCount":2,"feeDeduction":1250,"frontPictureUrl":"images/bills/5f9a594c6c1b722008acd6de/frontPicture.png","guaranteeStatus":1,"id":"5f9a594c6c1b722008acd6df","inOrderId":"5f9a594c6c1b722008acd6e0","inconsistentStatus":0,"internalBillId":"5f9a594c6c1b722008acd6de","isDirectSell":false,"issueDate":"2020-07-29","number":"230424100002820200729691499106","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"},"pledgeCount":0,"publisher":{"account":"15554807565","companyName":"临沂兴鲁商贸有限公司","handler":[{"channelType":1,"handlerName":"李四","handlerPhoneNo":"18648654235"}],"legalRepName":"张杰"},"publisherId":"5f6ef9496c1b7253b0862ccb","remainDays":271,"returnDraweeCount":0,"returnDrawerCount":0,"returnEndorsementCount":1,"status":100,"transferBank":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2},"type":1},"comment":"","handler":{"id":"","name":""}}],"size":1,"total":13}
     * statusCode : 0
     */

    private PayloadBean payload;
    private int statusCode;

    @NoArgsConstructor
    @Data
    public static class PayloadBean  {
        /**
         * results : [{"auditResult":{"comment":"","reason":[],"result":-1},"bill":{"acceptingBankName":"华夏银行股份有限公司","acceptingBankNumber":"304241000028","acceptingBankType":1,"amount":5.0E7,"backPictures":{"0e85fef0ba5240178dc0e81f5e64a1b8":"images/bills/5f9a594c6c1b722008acd6df/backPicture_0e85fef0ba5240178dc0e81f5e64a1b8.jpg"},"channelType":1,"createTimeInMillis":1603950924786,"currentState":0,"customDefect":"","doubleEndorsementCount":0,"draweeName":"超市有限公司","drawerName":"房地产有限公司","dueDate":"2021-07-28","endorseBank":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2},"endorseCount":2,"feeDeduction":1250,"frontPictureUrl":"images/bills/5f9a594c6c1b722008acd6de/frontPicture.png","guaranteeStatus":1,"id":"5f9a594c6c1b722008acd6df","inOrderId":"5f9a594c6c1b722008acd6e0","inconsistentStatus":0,"internalBillId":"5f9a594c6c1b722008acd6de","isDirectSell":false,"issueDate":"2020-07-29","number":"230424100002820200729691499106","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"},"pledgeCount":0,"publisher":{"account":"15554807565","companyName":"临沂兴鲁商贸有限公司","handler":[{"channelType":1,"handlerName":"李四","handlerPhoneNo":"18648654235"}],"legalRepName":"张杰"},"publisherId":"5f6ef9496c1b7253b0862ccb","remainDays":271,"returnDraweeCount":0,"returnDrawerCount":0,"returnEndorsementCount":1,"status":100,"transferBank":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2},"type":1},"comment":"","handler":{"id":"","name":""}}]
         * size : 1
         * total : 13
         */

        private int size;
        private int total;
        private List<ResultsBean> results;

        @NoArgsConstructor
        @Data
        public static class ResultsBean  {
            /**
             * auditResult : {"comment":"","reason":[],"result":-1}
             * bill : {"acceptingBankName":"华夏银行股份有限公司","acceptingBankNumber":"304241000028","acceptingBankType":1,"amount":5.0E7,"backPictures":{"0e85fef0ba5240178dc0e81f5e64a1b8":"images/bills/5f9a594c6c1b722008acd6df/backPicture_0e85fef0ba5240178dc0e81f5e64a1b8.jpg"},"channelType":1,"createTimeInMillis":1603950924786,"currentState":0,"customDefect":"","doubleEndorsementCount":0,"draweeName":"超市有限公司","drawerName":"房地产有限公司","dueDate":"2021-07-28","endorseBank":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2},"endorseCount":2,"feeDeduction":1250,"frontPictureUrl":"images/bills/5f9a594c6c1b722008acd6de/frontPicture.png","guaranteeStatus":1,"id":"5f9a594c6c1b722008acd6df","inOrderId":"5f9a594c6c1b722008acd6e0","inconsistentStatus":0,"internalBillId":"5f9a594c6c1b722008acd6de","isDirectSell":false,"issueDate":"2020-07-29","number":"230424100002820200729691499106","platform":{"id":"5f6eeb3d6c1b725440329883","name":"有票么"},"pledgeCount":0,"publisher":{"account":"15554807565","companyName":"临沂兴鲁商贸有限公司","handler":[{"channelType":1,"handlerName":"李四","handlerPhoneNo":"18648654235"}],"legalRepName":"张杰"},"publisherId":"5f6ef9496c1b7253b0862ccb","remainDays":271,"returnDraweeCount":0,"returnDrawerCount":0,"returnEndorsementCount":1,"status":100,"transferBank":{"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2},"type":1}
             * comment : 
             * handler : {"id":"","name":""}
             */

            private AuditResultBean auditResult;
            private BillBean bill;
            private String comment;
            private HandlerBeanX handler;

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

            @NoArgsConstructor
            @Data
            public static class BillBean  {
                /**
                 * acceptingBankName : 华夏银行股份有限公司
                 * acceptingBankNumber : 304241000028
                 * acceptingBankType : 1
                 * amount : 5.0E7
                 * backPictures : {"0e85fef0ba5240178dc0e81f5e64a1b8":"images/bills/5f9a594c6c1b722008acd6df/backPicture_0e85fef0ba5240178dc0e81f5e64a1b8.jpg"}
                 * channelType : 1
                 * createTimeInMillis : 1603950924786
                 * currentState : 0
                 * customDefect : 
                 * doubleEndorsementCount : 0
                 * draweeName : 超市有限公司
                 * drawerName : 房地产有限公司
                 * dueDate : 2021-07-28
                 * endorseBank : {"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}
                 * endorseCount : 2
                 * feeDeduction : 1250
                 * frontPictureUrl : images/bills/5f9a594c6c1b722008acd6de/frontPicture.png
                 * guaranteeStatus : 1
                 * id : 5f9a594c6c1b722008acd6df
                 * inOrderId : 5f9a594c6c1b722008acd6e0
                 * inconsistentStatus : 0
                 * internalBillId : 5f9a594c6c1b722008acd6de
                 * isDirectSell : false
                 * issueDate : 2020-07-29
                 * number : 230424100002820200729691499106
                 * platform : {"id":"5f6eeb3d6c1b725440329883","name":"有票么"}
                 * pledgeCount : 0
                 * publisher : {"account":"15554807565","companyName":"临沂兴鲁商贸有限公司","handler":[{"channelType":1,"handlerName":"李四","handlerPhoneNo":"18648654235"}],"legalRepName":"张杰"}
                 * publisherId : 5f6ef9496c1b7253b0862ccb
                 * remainDays : 271
                 * returnDraweeCount : 0
                 * returnDrawerCount : 0
                 * returnEndorsementCount : 1
                 * status : 100
                 * transferBank : {"accountName":"临沂洪立商贸有限公司","accountNumber":"15000100147605","applyStatus":1,"applyStatusHistory":{"1601108380656":{"applyStatus":1,"time":1601108380656}},"channelType":1,"cityId":"4730","cityName":"临沂市","createTimeInMillis":1601108380656,"entId":"5f6ef99b6c1b7253b0862cce","handlerEmail":"sdj@163.com","handlerId":"371311198602152548","handlerName":"李四","handlerPhoneNo":"18648654235","id":"5f6ef99c6c1b7253b0862cd1","name":"平安银行","number":"15000100147605","occBankChildCode":"307","occBankChildName":"平安银行股份有限公司临沂分行","occBankCnap":"307473000019","occBankCode":"PAB","occBankName":"平安银行","provinceId":"370","provinceName":"山东省","source":1,"type":2}
                 * type : 1
                 */

                private String acceptingBankName;
                private String acceptingBankNumber;
                private int acceptingBankType;
                private double amount;
                private BackPicturesBean backPictures;
                private int channelType;
                private long createTimeInMillis;
                private int currentState;
                private String customDefect;
                private int doubleEndorsementCount;
                private String draweeName;
                private String drawerName;
                private String dueDate;
                private EndorseBankBean endorseBank;
                private int endorseCount;
                private int feeDeduction;
                private String frontPictureUrl;
                private int guaranteeStatus;
                private String id;
                private String inOrderId;
                private int inconsistentStatus;
                private String internalBillId;
                private boolean isDirectSell;
                private String issueDate;
                private String number;
                private PlatformBean platform;
                private int pledgeCount;
                private PublisherBean publisher;
                private String publisherId;
                private int remainDays;
                private int returnDraweeCount;
                private int returnDrawerCount;
                private int returnEndorsementCount;
                private int status;
                private TransferBankBean transferBank;
                private int type;

                @NoArgsConstructor
                @Data
                public static class BackPicturesBean  {
                    /**
                     * 0e85fef0ba5240178dc0e81f5e64a1b8 : images/bills/5f9a594c6c1b722008acd6df/backPicture_0e85fef0ba5240178dc0e81f5e64a1b8.jpg
                     */

                    private String $0e85fef0ba5240178dc0e81f5e64a1b8;
                }

                @NoArgsConstructor
                @Data
                public static class EndorseBankBean  {
                    /**
                     * accountName : 临沂洪立商贸有限公司
                     * accountNumber : 15000100147605
                     * applyStatus : 1
                     * applyStatusHistory : {"1601108380656":{"applyStatus":1,"time":1601108380656}}
                     * channelType : 1
                     * cityId : 4730
                     * cityName : 临沂市
                     * createTimeInMillis : 1601108380656
                     * entId : 5f6ef99b6c1b7253b0862cce
                     * handlerEmail : sdj@163.com
                     * handlerId : 371311198602152548
                     * handlerName : 李四
                     * handlerPhoneNo : 18648654235
                     * id : 5f6ef99c6c1b7253b0862cd1
                     * name : 平安银行
                     * number : 15000100147605
                     * occBankChildCode : 307
                     * occBankChildName : 平安银行股份有限公司临沂分行
                     * occBankCnap : 307473000019
                     * occBankCode : PAB
                     * occBankName : 平安银行
                     * provinceId : 370
                     * provinceName : 山东省
                     * source : 1
                     * type : 2
                     */

                    private String accountName;
                    private String accountNumber;
                    private int applyStatus;
                    private ApplyStatusHistoryBean applyStatusHistory;
                    private int channelType;
                    private String cityId;
                    private String cityName;
                    private long createTimeInMillis;
                    private String entId;
                    private String handlerEmail;
                    private String handlerId;
                    private String handlerName;
                    private String handlerPhoneNo;
                    private String id;
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

                    @NoArgsConstructor
                    @Data
                    public static class ApplyStatusHistoryBean  {
                        /**
                         * 1601108380656 : {"applyStatus":1,"time":1601108380656}
                         */

                        private _$1601108380656Bean $1601108380656;

                        @NoArgsConstructor
                        @Data
                        public static class _$1601108380656Bean  {
                            /**
                             * applyStatus : 1
                             * time : 1601108380656
                             */

                            private int applyStatus;
                            private long time;
                        }
                    }
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
                public static class PublisherBean  {
                    /**
                     * account : 15554807565
                     * companyName : 临沂兴鲁商贸有限公司
                     * handler : [{"channelType":1,"handlerName":"李四","handlerPhoneNo":"18648654235"}]
                     * legalRepName : 张杰
                     */

                    private String account;
                    private String companyName;
                    private String legalRepName;
                    private List<HandlerBean> handler;

                    @NoArgsConstructor
                    @Data
                    public static class HandlerBean  {
                        /**
                         * channelType : 1
                         * handlerName : 李四
                         * handlerPhoneNo : 18648654235
                         */

                        private int channelType;
                        private String handlerName;
                        private String handlerPhoneNo;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class TransferBankBean  {
                    /**
                     * accountName : 临沂洪立商贸有限公司
                     * accountNumber : 15000100147605
                     * applyStatus : 1
                     * applyStatusHistory : {"1601108380656":{"applyStatus":1,"time":1601108380656}}
                     * channelType : 1
                     * cityId : 4730
                     * cityName : 临沂市
                     * createTimeInMillis : 1601108380656
                     * entId : 5f6ef99b6c1b7253b0862cce
                     * handlerEmail : sdj@163.com
                     * handlerId : 371311198602152548
                     * handlerName : 李四
                     * handlerPhoneNo : 18648654235
                     * id : 5f6ef99c6c1b7253b0862cd1
                     * name : 平安银行
                     * number : 15000100147605
                     * occBankChildCode : 307
                     * occBankChildName : 平安银行股份有限公司临沂分行
                     * occBankCnap : 307473000019
                     * occBankCode : PAB
                     * occBankName : 平安银行
                     * provinceId : 370
                     * provinceName : 山东省
                     * source : 1
                     * type : 2
                     */

                    private String accountName;
                    private String accountNumber;
                    private int applyStatus;
                    private ApplyStatusHistoryBeanX applyStatusHistory;
                    private int channelType;
                    private String cityId;
                    private String cityName;
                    private long createTimeInMillis;
                    private String entId;
                    private String handlerEmail;
                    private String handlerId;
                    private String handlerName;
                    private String handlerPhoneNo;
                    private String id;
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

                    @NoArgsConstructor
                    @Data
                    public static class ApplyStatusHistoryBeanX  {
                        /**
                         * 1601108380656 : {"applyStatus":1,"time":1601108380656}
                         */

                        private _$1601108380656BeanX $1601108380656;

                        @NoArgsConstructor
                        @Data
                        public static class _$1601108380656BeanX  {
                            /**
                             * applyStatus : 1
                             * time : 1601108380656
                             */

                            private int applyStatus;
                            private long time;
                        }
                    }
                }
            }

            @NoArgsConstructor
            @Data
            public static class HandlerBeanX  {
                /**
                 * id : 
                 * name : 
                 */

                private String id;
                private String name;
            }
        }
    }
}
