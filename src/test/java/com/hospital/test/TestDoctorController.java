package com.hospital.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hospital.Controller.DoctorController;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
class TestDoctorController {
	private static MockMvc mockMvc;
		@BeforeAll
		//To use before all the function should be static 
		public static void init()
		{
			mockMvc=MockMvcBuilders.standaloneSetup(DoctorController.class).build();
		}
		
		@Test
		void getDoctorByIdTest() throws Exception{
			mockMvc.perform(get("/doctors")).andDo(print()).andExpect(status().isOk());
		}
		
}