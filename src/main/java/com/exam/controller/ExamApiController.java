package com.exam.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.mapper.ExaminationMapper;
import com.exam.service.GradeService;
import com.exam.service.UserService;
import com.exam.util.ResultUtil;
import com.exam.vo.StatisticConditionVo;
import com.exam.vo.base.ResponseVo;

@Controller
public class ExamApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private ExaminationMapper examMapper;
	
	
	/**
	 * 学院及格人数统计接口
	 * @return
	 */
	@PostMapping("/api/aps")
	@ResponseBody
	public ResponseVo academyPassNumSta() {
		List<HashMap<String, Object>> list = userService.academyPassNumSta();
		if(!list.isEmpty()) {
			return ResultUtil.success("数据更新成功", list);
		}else {
			return ResultUtil.error("没有数据");
		}
	}
	
	/**
	 * 最近发布考试
	 * @return
	 */
	@PostMapping("/api/aes")
	@ResponseBody
	public ResponseVo recAddExamSta() {
		List<HashMap<String, Object>> examList = examMapper.recAddExamSta();
		if(!examList.isEmpty()) {
			return ResultUtil.success("数据更新成功", examList);
		}else {
			return ResultUtil.error("没有数据");
		}
	}
	
	@PostMapping("/api/uns")
	@ResponseBody
	public ResponseVo userNumSta(StatisticConditionVo vo) {
		List<HashMap<String, Object>> users = gradeService.examUserNumsAnalysis(vo);
		if(!users.isEmpty()) {
			return ResultUtil.success("数据更新成功", users);
		}else {
			return ResultUtil.error("没有数据");
		}
	}
	
}
