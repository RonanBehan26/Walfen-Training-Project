package BIM;

import java.util.List;

/*
 * https://forge.autodesk.com/en/docs/bim360/v1/reference/http/admin-v1-projects-projectId-users-GET/
 * BIM 360	/bim360/admin/v1/projects/{projectId}/users	GET - Jira
 */

public class bim360bim360projectIdusersGETOne {
	

public class AccessLevels {

public Boolean accountAdmin;
public Boolean projectAdmin;
public Boolean executive;

public AccessLevels withAccountAdmin(Boolean accountAdmin) {
this.accountAdmin = accountAdmin;
return this;
}

public AccessLevels withProjectAdmin(Boolean projectAdmin) {
this.projectAdmin = projectAdmin;
return this;
}

public AccessLevels withExecutive(Boolean executive) {
this.executive = executive;
return this;
}

}


public class Pagination {

public Integer limit;
public Integer offset;
public Integer totalResults;
public String nextUrl;
public String previousUrl;

public Pagination withLimit(Integer limit) {
this.limit = limit;
return this;
}

public Pagination withOffset(Integer offset) {
this.offset = offset;
return this;
}

public Pagination withTotalResults(Integer totalResults) {
this.totalResults = totalResults;
return this;
}

public Pagination withNextUrl(String nextUrl) {
this.nextUrl = nextUrl;
return this;
}

public Pagination withPreviousUrl(String previousUrl) {
this.previousUrl = previousUrl;
return this;
}

}

public class Phone {

public String number;
public String phoneType;
public String extension;

public Phone withNumber(String number) {
this.number = number;
return this;

}

public Phone withPhoneType(String phoneType) {
this.phoneType = phoneType;
return this;
}

public Phone withExtension(String extension) {
this.extension = extension;
return this;
}

}


public class Result {

public String id;
public String email;
public String name;
public String firstName;
public String lastName;
public String autodeskId;
public String anaylticsId;
public String addressLine1;
public String addressLine2;
public String city;
public String stateOrProvince;
public Integer postalCode;
public String country;
public String imageUrl;
public Phone phone;
public String jobTitle;
public String industry;
public String aboutMe;
public AccessLevels accessLevels;
public String companyId;
public List<String> roleIds = null;
public List<Service> services = null;

public Result withId(String id) {
this.id = id;
return this;
}

public Result withEmail(String email) {
this.email = email;
return this;
}

public Result withName(String name) {
this.name = name;
return this;
}

public Result withFirstName(String firstName) {
this.firstName = firstName;
return this;
}

public Result withLastName(String lastName) {
this.lastName = lastName;
return this;
}

public Result withAutodeskId(String autodeskId) {
this.autodeskId = autodeskId;
return this;
}

public Result withAnaylticsId(String anaylticsId) {
this.anaylticsId = anaylticsId;
return this;
}

public Result withAddressLine1(String addressLine1) {
this.addressLine1 = addressLine1;
return this;
}

public Result withAddressLine2(String addressLine2) {
this.addressLine2 = addressLine2;
return this;
}

public Result withCity(String city) {
this.city = city;
return this;
}

public Result withStateOrProvince(String stateOrProvince) {
this.stateOrProvince = stateOrProvince;
return this;
}

public Result withPostalCode(Integer postalCode) {
this.postalCode = postalCode;
return this;
}

public Result withCountry(String country) {
this.country = country;
return this;
}

public Result withImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
return this;
}

public Result withPhone(Phone phone) {
this.phone = phone;
return this;
}

public Result withJobTitle(String jobTitle) {
this.jobTitle = jobTitle;
return this;
}

public Result withIndustry(String industry) {
this.industry = industry;
return this;
}

public Result withAboutMe(String aboutMe) {
this.aboutMe = aboutMe;
return this;
}

public Result withAccessLevels(AccessLevels accessLevels) {
this.accessLevels = accessLevels;
return this;
}

public Result withCompanyId(String companyId) {
this.companyId = companyId;
return this;
}

public Result withRoleIds(List<String> roleIds) {
this.roleIds = roleIds;
return this;
}

public Result withServices(List<Service> services) {
this.services = services;
return this;
}

}


public class Service {

public String serviceName;
public String access;

public Service withServiceName(String serviceName) {
this.serviceName = serviceName;
return this;
}

public Service withAccess(String access) {
this.access = access;
return this;
}

}
}
	


