package com.example.tams.service;

import com.example.tams.model.*;
import com.example.tams.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MockDataService {

    private final ProjectMasterRepository projectRepo;
    private final TestSuiteMasterRepository suiteRepo;
    private final ContractMasterRepository contractRepo;
    private final ProjectTestSuiteMappingRepository projectSuiteRepo;
    private final ContractFieldPropertiesRepository fieldRepo;
    private final TestCaseMasterRepository caseRepo;
    private final TestSuiteTestCaseMappingRepository suiteCaseRepo;
    private final TestCaseVerificationContractsMappingRepository caseContractRepo;
    private final TestCaseVerificationsMasterRepository verificationRepo;
    private final TestDataMasterRepository dataRepo;
    private final VerificationParameterMasterRepository verificationParamRepo;
    private final ValidationsMasterRepository validationRepo;
    private final ValidationParameterMasterRepository validationParamRepo;
    private final ExpectedDataMasterRepository expectedDataRepo;
    private final TestExecutionMasterRepository executionRepo;
    private final TestRunResultsRepository runRepo;

    @Transactional
    public void generateMockData() {
        // 1. Core Masters
        ProjectMaster project = new ProjectMaster();
        project.setProjectName("Project Alpha");
        project.setProjectDesc("Description for Alpha");
        project = projectRepo.save(project);

        TestSuiteMaster suite = new TestSuiteMaster();
        suite.setSuiteName("E2E Suite");
        suite.setSuiteDesc("End to end tests");
        suite.setType("E2E_TEST");
        suite = suiteRepo.save(suite);

        ContractMaster contract = new ContractMaster();
        contract.setContractSchemaJson("{}");
        contract.setContractBaseJson("{}");
        contract = contractRepo.save(contract);

        // 2. Mappings and Secondary Masters
        ProjectTestSuiteMapping projectSuiteMapping = new ProjectTestSuiteMapping();
        projectSuiteMapping.setProject(project);
        projectSuiteMapping.setTestSuite(suite);
        projectSuiteRepo.save(projectSuiteMapping);

        ContractFieldProperties fieldProperties = new ContractFieldProperties();
        fieldProperties.setContract(contract);
        fieldProperties.setJsonKey("userId");
        fieldProperties.setIsMandatory("Y");
        fieldProperties.setFieldDataType("String");
        fieldProperties.setFieldValueType("UUID");
        fieldProperties.setAutoGenerationField("Y");
        fieldProperties.setFieldGenerationType("RANDOM");
        fieldProperties.setFieldFormat("UUID");
        fieldRepo.save(fieldProperties);

        TestCaseMaster testCase = new TestCaseMaster();
        testCase.setTestName("Login Test");
        testCase.setTestDescription("Verify user login");
        testCase.setAction("POST");
        testCase.setTriggerUrl("/api/login");
        testCase.setAppName("AuthService");
        testCase.setServiceName("LoginService");
        testCase.setInputPayloadFormat("JSON");
        testCase.setExecuteIfPrevSuccess("Y");
        testCase.setTriggerPayloadContract(contract);
        testCase = caseRepo.save(testCase);

        // 3. Tertiary
        TestSuiteTestCaseMapping suiteCaseMapping = new TestSuiteTestCaseMapping();
        suiteCaseMapping.setTestSuite(suite);
        suiteCaseMapping.setTestCase(testCase);
        suiteCaseMapping.setSequenceNo(1);
        suiteCaseRepo.save(suiteCaseMapping);

        TestCaseVerificationContractsMapping caseContractMapping = new TestCaseVerificationContractsMapping();
        caseContractMapping.setTestCase(testCase);
        caseContractMapping.setContract(contract);
        caseContractRepo.save(caseContractMapping);

        TestCaseVerificationsMaster verification = new TestCaseVerificationsMaster();
        verification.setTestCase(testCase);
        verification.setAppName("AuthService");
        verification.setServiceName("SessionService");
        verification.setBaseUrl("http://auth/sessions");
        verification.setSequenceNo(1);
        verification.setVerifyOnlyIfPrevSuccess("Y");
        verification = verificationRepo.save(verification);

        TestDataMaster testData = new TestDataMaster();
        testData.setTestCase(testCase);
        testData.setUploadedTestData("{\"user\":\"test\"}");
        testData.setFinalTestData("{\"user\":\"test\",\"pass\":\"123\"}");
        testData = dataRepo.save(testData);

        // 4. Verification Params and Validations
        VerificationParameterMaster verificationParam = new VerificationParameterMaster();
        verificationParam.setParamKey("token");
        verificationParam.setValueSource("HEADER");
        verificationParam.setParamValue("Bearer xyz");
        verificationParam.setVerification(verification);
        verificationParam.setSequenceNo(1);
        verificationParam.setValuePath("$.token");
        verificationParam.setValueDataType("String");
        verificationParamRepo.save(verificationParam);

        ValidationsMaster validation = new ValidationsMaster();
        validation.setVerification(verification);
        validation.setValidationType("STATUS_CODE");
        validation.setValidationName("Check 200");
        validation.setSequenceNo(1);
        validation.setExpectedOutcomeValue("200");
        validation.setPayloadContract(contract);
        validation = validationRepo.save(validation);

        // 5. Validation Params, Expected Data, Execution
        ValidationParameterMaster validationParam = new ValidationParameterMaster();
        validationParam.setValidation(validation);
        validationParam.setSequenceNo(1);
        validationParam.setParameterType("EXPECTED");
        validationParam.setParameterDataType("Integer");
        validationParam.setParameterValue("200");
        validationParamRepo.save(validationParam);

        ExpectedDataMaster expectedData = new ExpectedDataMaster();
        expectedData.setTestCase(testCase);
        expectedData.setTestData(testData);
        expectedData.setVerification(verification);
        expectedData.setValidation(validation);
        expectedData.setExpectedData("Success");
        expectedDataRepo.save(expectedData);

        TestExecutionMaster execution = new TestExecutionMaster();
        execution.setTestSuite(suite);
        execution.setStartTime(LocalDateTime.now().minusMinutes(10));
        execution.setEndTime(LocalDateTime.now());
        execution.setStatus("COMPLETED");
        execution = executionRepo.save(execution);

        // 6. Run Results
        TestRunResults result = new TestRunResults();
        result.setExecution(execution);
        result.setTestCase(testCase);
        result.setVerification(verification);
        result.setValidation(validation);
        result.setTestResult("PASS");
        result.setStatus("DONE");
        runRepo.save(result);
    }
}
