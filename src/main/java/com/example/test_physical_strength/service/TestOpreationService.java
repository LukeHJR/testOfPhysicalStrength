package com.example.test_physical_strength.service;

import com.example.test_physical_strength.dto.request.MakeUpExamRequest;
import com.example.test_physical_strength.dto.request.SlowMeasuringOrExemptingRequest;
import com.example.test_physical_strength.dto.request.TestReservationRequest;
import com.example.test_physical_strength.dto.response.StudentScoreRes;

import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-12
 */
public interface TestOpreationService {

    /**
     * @param
     * @return
     * @title   学生成绩查询
     * @author huangjiarui
     * @date 2018年5月12日
     */
    List<StudentScoreRes> searchScore(Long id);

    /**
     * @param
     * @return
     * @title   学生缓测、免测申请
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void slowMeasuringOrExempting(SlowMeasuringOrExemptingRequest request);

    /**
     * @param
     * @return
     * @title   学生申请补考
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void makeUpExam(MakeUpExamRequest request);

    /**
     * @param
     * @return
     * @title    体测预约
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void testReservation(TestReservationRequest request , String sid);
}
