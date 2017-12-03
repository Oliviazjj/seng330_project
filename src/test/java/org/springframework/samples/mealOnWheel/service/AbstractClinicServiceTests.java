///*
// * Copyright 2002-2013 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.springframework.samples.mealOnWheel.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Collection;
//import java.util.Date;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.samples.mealOnWheel.model.Employee;
//import org.springframework.samples.mealOnWheel.model.EmployeeShift;
//import org.springframework.samples.mealOnWheel.model.EmployEvent;
//import org.springframework.samples.mealOnWheel.model.Event;
//import org.springframework.samples.mealOnWheel.model.Contact;
//import org.springframework.samples.mealOnWheel.model.Inventory;
//import org.springframework.samples.mealOnWheel.model.Food;
//import org.springframework.samples.mealOnWheel.model.User;
//import org.springframework.samples.mealOnWheel.util.EntityUtils;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//
//public abstract class AbstractClinicServiceTests {
//
//    @Autowired
//    protected CompanyService clinicService;
//
//    @Test
//    public void shouldFindEmployeesByLastName() {
//        Collection<Employee> employees = this.clinicService.findEmployeeByLastName("Davis");
//        assertThat(employees.size()).isEqualTo(2);
//
//        employees = this.clinicService.findEmployeeByLastName("Daviss");
//        assertThat(employees.isEmpty()).isTrue();
//    }
//
//    @Test
//    public void shouldFindSingleEmployeeWithEmployEvent() {
//        Employee employee = this.companyService.findEmployeeById(1);
//        assertThat(employee.getLastName()).startsWith("Franklin");
//        assertThat(employee.getPets().size()).isEqualTo(1);
//        assertThat(employee.getPets().get(0).getType()).isNotNull();
//        assertThat(employee.getPets().get(0).getType().getName()).isEqualTo("cat");
//    }
//
//    @Test
//    @Transactional
//    public void shouldInsertEmployee() {
//        Collection<Employee> employees = this.clinicService.findEmployeeByLastName("Schultz");
//        int found = employees.size();
//
//        Employee employee = new Employee();
//        employee.setFirstName("Sam");
//        employee.setLastName("Schultz");
//        employee.setAddress("4, Evans Street");
//        employee.setCity("Wollongong");
//        employee.setTelephone("4444444444");
//        this.clinicService.saveEmployee(employee);
//        assertThat(employee.getId().longValue()).isNotEqualTo(0);
//
//        employees = this.clinicService.findEmployeeByLastName("Schultz");
//        assertThat(employees.size()).isEqualTo(found + 1);
//    }
//
//    @Test
//    @Transactional
//    public void shouldUpdateEmployee() {
//        Employee employee = this.clinicService.findEmployeeById(1);
//        String oldLastName = employee.getLastName();
//        String newLastName = oldLastName + "X";
//
//        employee.setLastName(newLastName);
//        this.clinicService.saveEmployee(employee);
//
//        // retrieving new name from database
//        employee = this.clinicService.findEmployeeById(1);
//        assertThat(employee.getLastName()).isEqualTo(newLastName);
//    }
//
//    @Test
//    public void shouldFindPetWithCorrectId() {
//        Pet pet7 = this.clinicService.findPetById(7);
//        assertThat(pet7.getName()).startsWith("Samantha");
//        assertThat(pet7.getEmployee().getFirstName()).isEqualTo("Jean");
//
//    }
//
//    @Test
//    public void shouldFindAllPetTypes() {
//        Collection<PetType> petTypes = this.clinicService.findPetTypes();
//
//        PetType petType1 = EntityUtils.getById(petTypes, PetType.class, 1);
//        assertThat(petType1.getName()).isEqualTo("cat");
//        PetType petType4 = EntityUtils.getById(petTypes, PetType.class, 4);
//        assertThat(petType4.getName()).isEqualTo("snake");
//    }
//
//    @Test
//    @Transactional
//    public void shouldInsertPetIntoDatabaseAndGenerateId() {
//        Employee employee6 = this.clinicService.findEmployeeById(6);
//        int found = employee6.getPets().size();
//
//        Pet pet = new Pet();
//        pet.setName("bowser");
//        Collection<PetType> types = this.clinicService.findPetTypes();
//        pet.setType(EntityUtils.getById(types, PetType.class, 2));
//        pet.setBirthDate(new Date());
//        employee6.addPet(pet);
//        assertThat(employee6.getPets().size()).isEqualTo(found + 1);
//
//        this.clinicService.savePet(pet);
//        this.clinicService.saveEmployee(employee6);
//
//        employee6 = this.clinicService.findEmployeeById(6);
//        assertThat(employee6.getPets().size()).isEqualTo(found + 1);
//        // checks that id has been generated
//        assertThat(pet.getId()).isNotNull();
//    }
//
//    @Test
//    @Transactional
//    public void shouldUpdatePetName() throws Exception {
//        Pet pet7 = this.clinicService.findPetById(7);
//        String oldName = pet7.getName();
//
//        String newName = oldName + "X";
//        pet7.setName(newName);
//        this.clinicService.savePet(pet7);
//
//        pet7 = this.clinicService.findPetById(7);
//        assertThat(pet7.getName()).isEqualTo(newName);
//    }
//
//    @Test
//    public void shouldFindVets() {
//        Collection<Vet> vets = this.clinicService.findVets();
//
//        Vet vet = EntityUtils.getById(vets, Vet.class, 3);
//        assertThat(vet.getLastName()).isEqualTo("Douglas");
//        assertThat(vet.getNrOfSpecialties()).isEqualTo(2);
//        assertThat(vet.getSpecialties().get(0).getName()).isEqualTo("dentistry");
//        assertThat(vet.getSpecialties().get(1).getName()).isEqualTo("surgery");
//    }
//
//    @Test
//    @Transactional
//    public void shouldAddNewVisitForPet() {
//        Pet pet7 = this.clinicService.findPetById(7);
//        int found = pet7.getVisits().size();
//        Visit visit = new Visit();
//        pet7.addVisit(visit);
//        visit.setDescription("test");
//        this.clinicService.saveVisit(visit);
//        this.clinicService.savePet(pet7);
//
//        pet7 = this.clinicService.findPetById(7);
//        assertThat(pet7.getVisits().size()).isEqualTo(found + 1);
//        assertThat(visit.getId()).isNotNull();
//    }
//
//    @Test
//       public void shouldFindVisitsByPetId() throws Exception {
//        Collection<Visit> visits = this.clinicService.findVisitsByPetId(7);
//        assertThat(visits.size()).isEqualTo(2);
//        Visit[] visitArr = visits.toArray(new Visit[visits.size()]);
//        assertThat(visitArr[0].getPet()).isNotNull();
//        assertThat(visitArr[0].getDate()).isNotNull();
//        assertThat(visitArr[0].getPet().getId()).isEqualTo(7);
//    }
//
//
//}