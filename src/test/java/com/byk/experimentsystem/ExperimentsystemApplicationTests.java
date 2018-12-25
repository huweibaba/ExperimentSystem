package com.byk.experimentsystem;

import com.byk.experimentsystem.Model.*;
import com.byk.experimentsystem.entity.*;
import com.byk.experimentsystem.mapper.*;
import com.byk.experimentsystem.service.*;

import com.byk.experimentsystem.service.impl.ClassRateImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.Class;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExperimentsystemApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private TeachingManagementService tms;
	@Autowired
	private UniversityMapper universityMapper;
	@Autowired
	private CollegeMapper collegeMapper;

    @Autowired
	private FastFileStorageClient fastFileStorageClient;

    @Autowired
	private TrackerClient trackerClient;

    @Autowired
	UniversityService universityService;

    @Autowired
	ExperimentStatistic experimentStatistic;

    @Autowired
	TeachingManagementService teachingManagementService;
    @Autowired
	Exp_dataMapper exp_dataMapper;
    @Autowired
	Exp_commitMapper exp_commitMapper;
    @Autowired
	PersonalSetting personalSetting;
    @Autowired
	ClassRate classRate;

    @Autowired
	ActionForecast actionForecast;

	@Test
	public void contextLoads() {
	}


	@Test
	public void loginTest() throws Exception//测试service层的login()方法
	{   Teacher teacher=new Teacher();
         teacher.setUserName("zhang");
         teacher.setPassword("123");
	   teacher= userService.login(teacher);
	   System.out.println(teacher.getTeaName());

	}

	@Test
	public void registerTest() throws Exception//测试service的register方法
	{Teacher teacher=new Teacher();
	teacher.setTeaName("张虎东");
	teacher.setUserName("zhang");
	teacher.setPassword("123");
	teacher.setTeaId(1);
	teacher.setSex(1);
	teacher.setCollegeId(1);
	teacher.setIsTeacherConfirm(0);
	userService.register(teacher);
	}

	@Test
	public void getUniversityTest() throws  Exception {
      List<University> universityList=universityService.getUniversitys();
      System.out.println(universityList.size());
      System.out.println(universityList.get(0).getName());

	}

	@Test
	public void getCampusTest() throws Exception{
		University university=new University();
		university.setId(1);
		List<Campus> campusList=universityService.getCampuses(university);
		System.out.println(campusList.size());
		System.out.println(campusList.get(0).getName());

	}

	@Test
	public void getColleges() throws  Exception
	{
     Campus campus=new Campus();
     campus.setId(1);
     List<College> collegeList=universityService.getColleges(campus);
     System.out.println(collegeList.size());
     System.out.println(collegeList.get(0).getName());
	}

	@Test
	public void getBuildings() throws  Exception
	{Campus campus=new Campus();
	campus.setId(1);
	 List<Building> buildingList=universityService.getBuildings(campus);
	 System.out.println(buildingList.size());
	 System.out.println(buildingList.get(0).getName());
	}


	@Test
	public void getClassroom() throws  Exception
	{
		Building building=new Building();
		building.setId(1);
		List<Classroom> classroomList=universityService.getClassroom(building);
		System.out.println(classroomList.size());
		System.out.println(classroomList.get(0).getName());
	}

	@Test
	public void releaseCourse() throws Exception{
		Course course=new Course();
		course.setCredit(3);
		course.setClassHour(64);
		course.setName("编译原理");
		course.setMajorId(1);
		teachingManagementService.releaseCourse(course);


	}
    @Test
	public void releaseExperimentTest() throws Exception
	{
		Experiment experiment=new Experiment();
		experiment.setReleaseUid(1);
		experiment.setCourseId(1);
		experiment.setClassroomId(2);
		experiment.setName("深度学习实验");
		teachingManagementService.releaseExperiment(experiment);

	}

	@Test
	public void getCoursesTest() throws Exception{
		Major major=new Major();
		major.setId(1);
		List<Course> courseList=teachingManagementService.getCourses(major);
		System.out.println(courseList.size());
	}

	@Test
	public void releaseExperimentTimeTest() throws Exception{
		Experiment experiment=new Experiment();
		experiment.setId(17);
		experiment.setDate(new Date());
		experiment.setTimeSlot("19:00-21:00");
		teachingManagementService.releaseExperimentTime(experiment);

	}

	@Test
	public void getNoReleaseExperimentTest() throws Exception
	{
		PageModel pageModel=new PageModel();
		pageModel.setPageSize(2);
		pageModel.setPageNum(1);
		Teacher teacher=new Teacher();
		teacher.setId(1);
		pageModel=teachingManagementService.getNoReleaseExperiments(pageModel,teacher);
		List<Experiment> experimentList=pageModel.getList();
		System.out.println(experimentList.get(0).getName());
	}

	@Test
	public void getReleasedExperimentTest() throws Exception
	{
		PageModel pageModel=new PageModel();
		pageModel.setPageSize(2);
		pageModel.setPageNum(1);
		Teacher teacher=new Teacher();
		teacher.setId(1);
		pageModel=teachingManagementService.getReleasedExperiments(pageModel,teacher);
		List<Experiment> experimentList=pageModel.getList();
		System.out.println(experimentList.get(0).getName());
	}

	@Test
	public void releaseDataTest() throws Exception
	{
		Experiment experiment=new Experiment();
		Teacher teacher=new Teacher();
		experiment.setId(17);
		teacher.setId(1);
		MultipartFile[] multipartFiles=new MultipartFile[0];
		teachingManagementService.releaseData(multipartFiles,experiment,teacher);
		Map map=new HashMap();
		File_user[] file_userList=new File_user[1];
		File_user file_user1=new File_user();
		file_user1.setId(4);
		file_userList[0]=file_user1;
		map.put("experiment",experiment);
		map.put("file_userList",file_userList);
		exp_dataMapper.insertRelations(map);
	}

	@Test
	public void downloadTest() throws Exception
	{
		File file=new File("/home/huwei/c/download");
		FileOutputStream outputStream=new FileOutputStream(file);
		com.byk.experimentsystem.entity.File file1 =new com.byk.experimentsystem.entity.File();
		file1.setFilePath("group1/M00/00/00/wKgABFwMpieAZxPLABbveWl5rKM741.jpg");
		teachingManagementService.download(outputStream,file1);
	}



	@Test
	public void deleteFileTest() throws  Exception
	{
		com.byk.experimentsystem.entity.File file=new com.byk.experimentsystem.entity.File();
		file.setFilePath("group1/M00/00/00/wKgABFwNOxiARfKZAAAAAAAAAAA163.txt");
		file.setId(25);
		teachingManagementService.deleteFile(file);
	}


	@Test
	public void getStuOfExperimentTest() throws  Exception
	{
		Experiment experiment=new Experiment();
		experiment.setId(17);
		PageModel pageModel=new PageModel();
		pageModel.setPageSize(3);
		pageModel.setPageNum(1);
		 pageModel=teachingManagementService.getStuOfExperiment(pageModel,experiment);
		 List<User> userList=pageModel.getList();
		System.out.println(userList.get(0).getUserName());
	}

	@Test
	public void getWorkTest() throws  Exception
	{
		Experiment experiment=new Experiment();
		User user=new User();
		experiment.setId(17);
		user.setId(1);

		List<Exp_commit> exp_commitList=teachingManagementService.getWork(experiment,user);
		System.out.println(exp_commitList.get(0).getAnswer());
	}

	@Test
	public void getImgUrlByFile_userId() throws  Exception
	{File_user file_user=new File_user();
	file_user.setId(4);
	String imgUrl=teachingManagementService.getImgUrlByFile_userId(file_user);
	System.out.println(imgUrl);

	}

	@Test
	public void updatePersonalMessage() throws  Exception
	{
		Teacher teacher=new Teacher();
		teacher.setId(1);
		teacher.setEmail("2320206897@qq.com");
		Date date=new Date();
		teacher.setCreatedat(date);
		teacher.setUpdatedat(date);
		personalSetting.updatePersonalMessage(teacher);

	}

	@Test
	public void updateExperiment() throws Exception
	{
		Experiment experiment=new Experiment();
		experiment.setId(17);
		Date date=new Date();
		experiment.setCreatedat(date);
		experiment.setUpdatedat(date);
		experiment.setDate(new Date());
		personalSetting.updateExperiment(experiment);
	}



	@Test
	public void getScoreOfClass() throws Exception{
		Experiment experiment=new Experiment();
		experiment.setId(18);
		com.byk.experimentsystem.entity.Class class1=new com.byk.experimentsystem.entity.Class();
		class1.setId(1);
		ScoreStatisticModel scoreStaticModel=experimentStatistic.getScoreOfClass(experiment,class1);
		System.out.println(scoreStaticModel.getAverageScore());
	}

	@Test
	public void getScoreOfGrade() throws Exception{
		Experiment experiment=new Experiment();
		experiment.setId(18);

		ScoreStatisticModel scoreStaticModel=experimentStatistic.getScoreOfGrade(experiment);
		System.out.println(scoreStaticModel.getAverageScore());
	}


	@Test
	public void  getStuScoreParse() throws Exception
	{
		User user=new User();
		user.setId(1);
		StuActionStatisticModel scoreStaticModel=experimentStatistic.getStuScoreParse(user);
		System.out.println(scoreStaticModel.getAverageScore());

	}

	@Test
	public void getCurrentClassRate() throws Exception
	{
		Experiment experiment=new Experiment();
		experiment.setId(17);
		ClassRateModel classRateModel=classRate.getCurrentClassRate(experiment);
		System.out.println(classRateModel.getClassRate());

	}

	@Test
	public void scoreForecastTest() throws Exception
	{   User user=new User();
	    user.setId(1);
		Map map=actionForecast.scoreForecast(user);
		System.out.println(map.get("forecastScore"));
	}

	@Test
	public void forecastQuestionsTest() throws Exception
	{
		TestQuestions testQuestions=actionForecast.forecastQuestions();
		System.out.println(testQuestions);
	}










}

//wKgABFwKb6aAHcKQACPUAknG8po732.jpg
//M00/00/00/wKgABFwKcE2AU3sLACPUAknG8po137.jpg
//M00/00/00/wKgABFwKjXuADMXHACPUAknG8po807.jpg


