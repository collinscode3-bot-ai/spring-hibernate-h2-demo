package com.example.tams.service;

import com.example.tams.model.*;
import com.example.tams.repository.*;
import com.example.tams.util.IdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MockDataService {

    private final ProjectRepository projectRepo;
    private final TestSuiteRepository suiteRepo;
    private final ContractRepository contractRepo;
    private final ProjectTestSuiteRepository projectSuiteRepo;
    private final ContractFieldPropertyRepository fieldRepo;
    private final TestCaseRepository caseRepo;
    private final TestSuiteTestCaseRepository suiteCaseRepo;
    private final TestCaseVerificationContractRepository caseContractRepo;
    private final TestCaseVerificationsContractRepository verificationsContractRepo;
    private final TestCaseVerificationRepository verificationRepo;
    private final TestDataRepository dataRepo;
    private final VerificationParameterRepository verificationParamRepo;
    private final ValidationRepository validationRepo;
    private final ValidationParameterRepository validationParamRepo;
    private final ExpectedDataRepository expectedDataRepo;
    private final TestExecutionRepository executionRepo;
    private final TestRunResultRepository runRepo;

    @Transactional
    public void generateMockData() {
        // 1. Core Masters
        Project project = new Project();
        project.setProjectId(IdUtils.generateId("PRJ"));
        project.setProjectName("Project Alpha");
        project.setProjectDesc("Description for Alpha");
        project = projectRepo.save(project);

        TestSuite suite = new TestSuite();
        suite.setTestSuiteId(IdUtils.generateId("TS"));
        suite.setSuiteName("E2E Suite");
        suite.setSuiteDesc("End to end tests");
        suite.setType("E2E_TEST");
        suite = suiteRepo.save(suite);

        Contract contract = new Contract();
        contract.setContractId(IdUtils.generateId("CON"));
        contract.setContractSchemaJson("{}");
        contract.setContractBaseJson("{}");
        contract = contractRepo.save(contract);

        // 2. Mappings and Secondary Masters
        ProjectTestSuite projectSuiteMapping = new ProjectTestSuite();
        projectSuiteMapping.setMappingId(IdUtils.generateId("PTS"));
        projectSuiteMapping.setProject(project);
        projectSuiteMapping.setTestSuite(suite);
        projectSuiteRepo.save(projectSuiteMapping);

        ContractFieldProperty fieldProperties = new ContractFieldProperty();
        fieldProperties.setFieldId(IdUtils.generateId("CFP"));
        fieldProperties.setContract(contract);
        fieldProperties.setJsonKey("userId");
        fieldProperties.setIsMandatory("Y");
        fieldProperties.setFieldDataType("String");
        fieldProperties.setFieldValueType("UUID");
        fieldProperties.setAutoGenerationField("Y");
        fieldProperties.setFieldGenerationType("RANDOM");
        fieldProperties.setFieldFormat("UUID");
        fieldRepo.save(fieldProperties);

        TestCase testCase = new TestCase();
        testCase.setTestCaseId(IdUtils.generateId("TC"));
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
        TestSuiteTestCase suiteCaseMapping = new TestSuiteTestCase();
        suiteCaseMapping.setMappingId(IdUtils.generateId("TTC"));
        suiteCaseMapping.setTestSuite(suite);
        suiteCaseMapping.setTestCase(testCase);
        suiteCaseMapping.setSequenceNo(1);
        suiteCaseRepo.save(suiteCaseMapping);

        TestCaseVerificationContract caseContractMapping = new TestCaseVerificationContract();
        caseContractMapping.setMappingId(IdUtils.generateId("TVC"));
        caseContractMapping.setTestCase(testCase);
        caseContractMapping.setContract(contract);
        caseContractRepo.save(caseContractMapping);

        TestCaseVerificationsContract verificationsContractMapping = new TestCaseVerificationsContract();
        verificationsContractMapping.setMappingId(IdUtils.generateId("VCM"));
        verificationsContractMapping.setTestCase(testCase);
        verificationsContractMapping.setContract(contract);
        verificationsContractRepo.save(verificationsContractMapping);

        TestCaseVerification verification = new TestCaseVerification();
        verification.setVerificationId(IdUtils.generateId("VER"));
        verification.setTestCase(testCase);
        verification.setAppName("AuthService");
        verification.setServiceName("SessionService");
        verification.setBaseUrl("http://auth/sessions");
        verification.setSequenceNo(1);
        verification.setVerifyOnlyIfPrevSuccess("Y");
        verification = verificationRepo.save(verification);

        TestData testData = new TestData();
        testData.setTestDataId(IdUtils.generateId("TD"));
        testData.setTestCase(testCase);
        testData.setUploadedTestData("{\"user\":\"test\"}");
        testData.setFinalTestData("{\"user\":\"test\",\"pass\":\"123\"}");
        testData = dataRepo.save(testData);

        // 4. Verification Params and Validations
        VerificationParameter verificationParam = new VerificationParameter();
        verificationParam.setParameterId(IdUtils.generateId("VP"));
        verificationParam.setParamKey("token");
        verificationParam.setValueSource("HEADER");
        verificationParam.setParamValue("Bearer xyz");
        verificationParam.setVerification(verification);
        verificationParam.setSequenceNo(1);
        verificationParam.setValuePath("$.token");
        verificationParam.setValueDataType("String");
        verificationParamRepo.save(verificationParam);

        Validation validation = new Validation();
        validation.setValidationId(IdUtils.generateId("VAL"));
        validation.setVerification(verification);
        validation.setValidationType("STATUS_CODE");
        validation.setValidationName("Check 200");
        validation.setSequenceNo(1);
        validation.setExpectedOutcomeValue("200");
        validation.setPayloadContract(contract);
        validation = validationRepo.save(validation);

        // 5. Validation Params, Expected Data, Execution
        ValidationParameter validationParam = new ValidationParameter();
        validationParam.setParameterId(IdUtils.generateId("VLP"));
        validationParam.setValidation(validation);
        validationParam.setSequenceNo(1);
        validationParam.setParameterType("EXPECTED");
        validationParam.setParameterDataType("Integer");
        validationParam.setParameterValue("200");
        validationParamRepo.save(validationParam);

        ExpectedData expectedData = new ExpectedData();
        expectedData.setExpectedDataId(IdUtils.generateId("ED"));
        expectedData.setTestCase(testCase);
        expectedData.setTestData(testData);
        expectedData.setVerification(verification);
        expectedData.setValidation(validation);
        expectedData.setExpectedData("Success");
        expectedDataRepo.save(expectedData);

        TestExecution execution = new TestExecution();
        execution.setExecutionId(IdUtils.generateId("EXE"));
        execution.setTestSuite(suite);
        execution.setStartTime(LocalDateTime.now().minusMinutes(10));
        execution.setEndTime(LocalDateTime.now());
        execution.setStatus("COMPLETED");
        execution = executionRepo.save(execution);

        // 6. Run Results
        TestRunResult result = new TestRunResult();
        result.setRunId(IdUtils.generateId("RUN"));
        result.setExecution(execution);
        result.setTestCase(testCase);
        result.setVerification(verification);
        result.setValidation(validation);
        result.setTestResult("PASS");
        result.setStatus("DONE");
        runRepo.save(result);
    }
}
