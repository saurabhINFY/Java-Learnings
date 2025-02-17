package org.learnings.streams.service.factory;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learnings.streams.Enum.City;
import org.learnings.streams.Enum.Department;
import org.learnings.streams.dto.Student;
import org.learnings.streams.helper.TestDataUtil;
import org.learnings.streams.service.FrequentlyAskedQuestionService;
import org.learnings.streams.service.StudentService;
import org.learnings.streams.service.impl.FrequentlyAskedQuestionServiceImpl;
import org.learnings.streams.service.impl.StudentServiceImpl;

public class OperationFactory {
    private static Logger log = LogManager.getLogger(OperationFactory.class);

    private OperationFactory() {
    }

    /**
     * Select the stream service based on test data name
     * 
     * @param serviceName
     */
    public static void startService(String serviceName) {
        if ("student".equalsIgnoreCase(serviceName)) {
            List<Student> studentTestData = TestDataUtil.perpareStudentData();
            StudentService studentService = new StudentServiceImpl(studentTestData);
            log.info("Started with Student Service");
            studentOperations(studentService);
        } else if ("faq".equalsIgnoreCase(serviceName)) {
            FrequentlyAskedQuestionService frequentlyAskedQuestionService = new FrequentlyAskedQuestionServiceImpl();
            commonlyAskedStremInterviewQuestion(frequentlyAskedQuestionService);
        }
    }

    /**
     * Start all possible stream operation on Students based on Student Service
     * 
     * @param studentService
     */
    private static void studentOperations(StudentService studentService) {
        studentService.groupStudentByDepartmentName(Department.COMPUTER_SCIENCE.value);
        studentService.findMaxAgeOfStudent();
        studentService.findDepartmentWithMaximumStudents();
        studentService.findStudentsWhoLivesIn(City.DELHI.value);
        studentService.findAverageAgeOfMaleAndFemaleStudents();
        studentService.findAverageRankInAllDepartments();
        studentService.findHighestRankInEachDepartment();
        studentService.findListOfStudentSortedByRank();
    }

    /**
     * all possible misc question on streams
     * 
     * @param frequentlyAskedQuestionService
     */
    private static void commonlyAskedStremInterviewQuestion(
            FrequentlyAskedQuestionService frequentlyAskedQuestionService) {
        frequentlyAskedQuestionService.secondDuplicateFromList();
    }
}
