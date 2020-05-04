package com.edination.api.eligibility.model;

import javax.persistence.*;

@Entity
@Table(name = "EdiDataElement271")
public class EdiDataElement271 {
    @Id
    private String subscriberPrimaryIdentifier;
    private String  traceTypeCode;
    private String subscriberLastName;
    private String  subscriberFirstName;
    private String subscriberNameSuffix;
    private String referenceIdentificationQualifier;
    private String subscriberSupplementalIdentifier;
    private String subscriberAddressLine;
    private String  subscriberCityName;
    private String   subscriberStateCode;
    private String  subscriberZipCode;
    private String  dateTimeQualifier;
    private String benefitDateTimePeriod;
    private String  eligibilityorBenefitInformation;
    private String  serviceTypeCode;
    private String  insuranceTypeCode;
    private String  timePeriodQualifier;
    private String benefitAmount;
    private String quantity;
    private String compositeMedicalProcedureIdentifier;
    private String serviceIDQualifier;
    private String procedureCode;
    private String procedureModifier;
    private String freeFormMessageText;
    private String quantityQualifier;
    private String  identificationCodeQualifier;
    private String  benefitRelatedEntityIdentifier;
    private String  entityIdentifierCode;
    private String  entityTypeQualifier;
    private String  benefitRelatedEntityLast;
    private String  benefitRelatedEntityAddressLine;
    private String  benefitRelatedEntityCityName;
    private String     benefitRelatedEntityStateCode;
    private String     benefitRelatedEntityZipCode;
    private String mrnNumber;
    public EdiDataElement271(){}
    public EdiDataElement271(String subscriberPrimaryIdentifier, String traceTypeCode, String subscriberLastName, String subscriberFirstName, String subscriberNameSuffix, String referenceIdentificationQualifier, String subscriberSupplementalIdentifier, String subscriberAddressLine, String subscriberCityName, String subscriberStateCode, String subscriberZipCode, String dateTimeQualifier, String benefitDateTimePeriod, String eligibilityorBenefitInformation, String serviceTypeCode, String insuranceTypeCode, String timePeriodQualifier, String benefitAmount, String quantity, String compositeMedicalProcedureIdentifier, String serviceIDQualifier, String procedureCode, String procedureModifier, String freeFormMessageText, String quantityQualifier, String identificationCodeQualifier, String benefitRelatedEntityIdentifier, String entityIdentifierCode, String entityTypeQualifier, String benefitRelatedEntityLast, String benefitRelatedEntityAddressLine, String benefitRelatedEntityCityName, String benefitRelatedEntityStateCode, String benefitRelatedEntityZipCode,String mrnNumber) {
        this.subscriberPrimaryIdentifier = subscriberPrimaryIdentifier;
        this.traceTypeCode = traceTypeCode;
        this.subscriberLastName = subscriberLastName;
        this.subscriberFirstName = subscriberFirstName;
        this.subscriberNameSuffix = subscriberNameSuffix;
        this.referenceIdentificationQualifier = referenceIdentificationQualifier;
        this.subscriberSupplementalIdentifier = subscriberSupplementalIdentifier;
        this.subscriberAddressLine = subscriberAddressLine;
        this.subscriberCityName = subscriberCityName;
        this.subscriberStateCode = subscriberStateCode;
        this.subscriberZipCode = subscriberZipCode;
        this.dateTimeQualifier = dateTimeQualifier;
        this.benefitDateTimePeriod = benefitDateTimePeriod;
        this.eligibilityorBenefitInformation = eligibilityorBenefitInformation;
        this.serviceTypeCode = serviceTypeCode;
        this.insuranceTypeCode = insuranceTypeCode;
        this.timePeriodQualifier = timePeriodQualifier;
        this.benefitAmount = benefitAmount;
        this.quantity = quantity;
        this.compositeMedicalProcedureIdentifier = compositeMedicalProcedureIdentifier;
        this.serviceIDQualifier = serviceIDQualifier;
        this.procedureCode = procedureCode;
        this.procedureModifier = procedureModifier;
        this.freeFormMessageText = freeFormMessageText;
        this.quantityQualifier = quantityQualifier;
        this.identificationCodeQualifier = identificationCodeQualifier;
        this.benefitRelatedEntityIdentifier = benefitRelatedEntityIdentifier;
        this.entityIdentifierCode = entityIdentifierCode;
        this.entityTypeQualifier = entityTypeQualifier;
        this.benefitRelatedEntityLast = benefitRelatedEntityLast;
        this.benefitRelatedEntityAddressLine = benefitRelatedEntityAddressLine;
        this.benefitRelatedEntityCityName = benefitRelatedEntityCityName;
        this.benefitRelatedEntityStateCode = benefitRelatedEntityStateCode;
        this.benefitRelatedEntityZipCode = benefitRelatedEntityZipCode;
        this.mrnNumber= mrnNumber;
    }


    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }



    public String getSubscriberPrimaryIdentifier() {
        return subscriberPrimaryIdentifier;
    }

    public void setSubscriberPrimaryIdentifier(String subscriberPrimaryIdentifier) {
        this.subscriberPrimaryIdentifier = subscriberPrimaryIdentifier;
    }

    public String getTraceTypeCode() {
        return traceTypeCode;
    }

    public void setTraceTypeCode(String traceTypeCode) {
        this.traceTypeCode = traceTypeCode;
    }

    public String getSubscriberLastName() {
        return subscriberLastName;
    }

    public void setSubscriberLastName(String subscriberLastName) {
        this.subscriberLastName = subscriberLastName;
    }

    public String getSubscriberFirstName() {
        return subscriberFirstName;
    }

    public void setSubscriberFirstName(String subscriberFirstName) {
        this.subscriberFirstName = subscriberFirstName;
    }

    public String getSubscriberNameSuffix() {
        return subscriberNameSuffix;
    }

    public void setSubscriberNameSuffix(String subscriberNameSuffix) {
        this.subscriberNameSuffix = subscriberNameSuffix;
    }

    public String getReferenceIdentificationQualifier() {
        return referenceIdentificationQualifier;
    }

    public void setReferenceIdentificationQualifier(String referenceIdentificationQualifier) {
        this.referenceIdentificationQualifier = referenceIdentificationQualifier;
    }

    public String getSubscriberSupplementalIdentifier() {
        return subscriberSupplementalIdentifier;
    }

    public void setSubscriberSupplementalIdentifier(String subscriberSupplementalIdentifier) {
        this.subscriberSupplementalIdentifier = subscriberSupplementalIdentifier;
    }

    public String getSubscriberAddressLine() {
        return subscriberAddressLine;
    }

    public void setSubscriberAddressLine(String subscriberAddressLine) {
        this.subscriberAddressLine = subscriberAddressLine;
    }

    public String getSubscriberCityName() {
        return subscriberCityName;
    }

    public void setSubscriberCityName(String subscriberCityName) {
        this.subscriberCityName = subscriberCityName;
    }

    public String getSubscriberStateCode() {
        return subscriberStateCode;
    }

    public void setSubscriberStateCode(String subscriberStateCode) {
        this.subscriberStateCode = subscriberStateCode;
    }

    public String getSubscriberZipCode() {
        return subscriberZipCode;
    }

    public void setSubscriberZipCode(String subscriberZipCode) {
        this.subscriberZipCode = subscriberZipCode;
    }

    public String getDateTimeQualifier() {
        return dateTimeQualifier;
    }

    public void setDateTimeQualifier(String dateTimeQualifier) {
        this.dateTimeQualifier = dateTimeQualifier;
    }

    public String getBenefitDateTimePeriod() {
        return benefitDateTimePeriod;
    }

    public void setBenefitDateTimePeriod(String benefitDateTimePeriod) {
        this.benefitDateTimePeriod = benefitDateTimePeriod;
    }

    public String getEligibilityorBenefitInformation() {
        return eligibilityorBenefitInformation;
    }

    public void setEligibilityorBenefitInformation(String eligibilityorBenefitInformation) {
        this.eligibilityorBenefitInformation = eligibilityorBenefitInformation;
    }

    public String getServiceTypeCode() {
        return serviceTypeCode;
    }

    public void setServiceTypeCode(String serviceTypeCode) {
        this.serviceTypeCode = serviceTypeCode;
    }

    public String getInsuranceTypeCode() {
        return insuranceTypeCode;
    }

    public void setInsuranceTypeCode(String insuranceTypeCode) {
        this.insuranceTypeCode = insuranceTypeCode;
    }

    public String getTimePeriodQualifier() {
        return timePeriodQualifier;
    }

    public void setTimePeriodQualifier(String timePeriodQualifier)
    {
        this.timePeriodQualifier = timePeriodQualifier;
    }

    public String getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(String benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCompositeMedicalProcedureIdentifier() {
        return compositeMedicalProcedureIdentifier;
    }

    public void setCompositeMedicalProcedureIdentifier(String compositeMedicalProcedureIdentifier) {
        this.compositeMedicalProcedureIdentifier = compositeMedicalProcedureIdentifier;
    }

    public String getServiceIDQualifier() {
        return serviceIDQualifier;
    }

    public void setServiceIDQualifier(String serviceIDQualifier) {
        this.serviceIDQualifier = serviceIDQualifier;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getProcedureModifier() {
        return procedureModifier;
    }

    public void setProcedureModifier(String procedureModifier) {
        this.procedureModifier = procedureModifier;
    }

    public String getFreeFormMessageText() {
        return freeFormMessageText;
    }

    public void setFreeFormMessageText(String freeFormMessageText) {
        this.freeFormMessageText = freeFormMessageText;
    }

    public String getQuantityQualifier() {
        return quantityQualifier;
    }

    public void setQuantityQualifier(String quantityQualifier) {
        this.quantityQualifier = quantityQualifier;
    }

    public String getIdentificationCodeQualifier() {
        return identificationCodeQualifier;
    }

    public void setIdentificationCodeQualifier(String identificationCodeQualifier) {
        this.identificationCodeQualifier = identificationCodeQualifier;
    }

    public String getBenefitRelatedEntityIdentifier() {
        return benefitRelatedEntityIdentifier;
    }

    public void setBenefitRelatedEntityIdentifier(String benefitRelatedEntityIdentifier) {
        this.benefitRelatedEntityIdentifier = benefitRelatedEntityIdentifier;
    }

    public String getEntityIdentifierCode() {
        return entityIdentifierCode;
    }

    public void setEntityIdentifierCode(String entityIdentifierCode) {
        this.entityIdentifierCode = entityIdentifierCode;
    }

    public String getEntityTypeQualifier() {
        return entityTypeQualifier;
    }

    public void setEntityTypeQualifier(String entityTypeQualifier) {
        this.entityTypeQualifier = entityTypeQualifier;
    }

    public String getBenefitRelatedEntityLast() {
        return benefitRelatedEntityLast;
    }

    public void setBenefitRelatedEntityLast(String benefitRelatedEntityLast) {
        this.benefitRelatedEntityLast = benefitRelatedEntityLast;
    }

    public String getBenefitRelatedEntityAddressLine() {
        return benefitRelatedEntityAddressLine;
    }

    public void setBenefitRelatedEntityAddressLine(String benefitRelatedEntityAddressLine) {
        this.benefitRelatedEntityAddressLine = benefitRelatedEntityAddressLine;
    }

    public String getBenefitRelatedEntityCityName() {
        return benefitRelatedEntityCityName;
    }

    public void setBenefitRelatedEntityCityName(String benefitRelatedEntityCityName) {
        this.benefitRelatedEntityCityName = benefitRelatedEntityCityName;
    }

    public String getBenefitRelatedEntityStateCode() {
        return benefitRelatedEntityStateCode;
    }

    public void setBenefitRelatedEntityStateCode(String benefitRelatedEntityStateCode) {
        this.benefitRelatedEntityStateCode = benefitRelatedEntityStateCode;
    }

    public String getBenefitRelatedEntityZipCode() {
        return benefitRelatedEntityZipCode;
    }

    public void setBenefitRelatedEntityZipCode(String benefitRelatedEntityZipCode) {
        this.benefitRelatedEntityZipCode = benefitRelatedEntityZipCode;
    }

    @Override
    public String toString() {
        return "EdiDataElement271{" +
                "subscriberPrimaryIdentifier='" + subscriberPrimaryIdentifier + '\'' +
                ", traceTypeCode='" + traceTypeCode + '\'' +
                ", subscriberLastName='" + subscriberLastName + '\'' +
                ", subscriberFirstName='" + subscriberFirstName + '\'' +
                ", subscriberNameSuffix='" + subscriberNameSuffix + '\'' +
                ", referenceIdentificationQualifier='" + referenceIdentificationQualifier + '\'' +
                ", subscriberSupplementalIdentifier='" + subscriberSupplementalIdentifier + '\'' +
                ", subscriberAddressLine='" + subscriberAddressLine + '\'' +
                ", subscriberCityName='" + subscriberCityName + '\'' +
                ", subscriberStateCode='" + subscriberStateCode + '\'' +
                ", subscriberZipCode='" + subscriberZipCode + '\'' +
                ", dateTimeQualifier='" + dateTimeQualifier + '\'' +
                ", benefitDateTimePeriod='" + benefitDateTimePeriod + '\'' +
                ", eligibilityorBenefitInformation='" + eligibilityorBenefitInformation + '\'' +
                ", serviceTypeCode='" + serviceTypeCode + '\'' +
                ", insuranceTypeCode='" + insuranceTypeCode + '\'' +
                ", timePeriodQualifier='" + timePeriodQualifier + '\'' +
                ", benefitAmount='" + benefitAmount + '\'' +
                ", quantity='" + quantity + '\'' +
                ", compositeMedicalProcedureIdentifier='" + compositeMedicalProcedureIdentifier + '\'' +
                ", serviceIDQualifier='" + serviceIDQualifier + '\'' +
                ", procedureCode='" + procedureCode + '\'' +
                ", procedureModifier='" + procedureModifier + '\'' +
                ", freeFormMessageText='" + freeFormMessageText + '\'' +
                ", quantityQualifier='" + quantityQualifier + '\'' +
                ", identificationCodeQualifier='" + identificationCodeQualifier + '\'' +
                ", benefitRelatedEntityIdentifier='" + benefitRelatedEntityIdentifier + '\'' +
                ", entityIdentifierCode='" + entityIdentifierCode + '\'' +
                ", entityTypeQualifier='" + entityTypeQualifier + '\'' +
                ", benefitRelatedEntityLast='" + benefitRelatedEntityLast + '\'' +
                ", benefitRelatedEntityAddressLine='" + benefitRelatedEntityAddressLine + '\'' +
                ", benefitRelatedEntityCityName='" + benefitRelatedEntityCityName + '\'' +
                ", benefitRelatedEntityStateCode='" + benefitRelatedEntityStateCode + '\'' +
                ", benefitRelatedEntityZipCode=" + benefitRelatedEntityZipCode +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}

