Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");
 
Ynzc.manage.RoleStore = new Ext.data.Store( {
	url : 'main/role.html?action=getAllRole',
	autoLoad:true,
	reader : new Ext.data.JsonReader({
				root : 'Role',
				id : 'role',
				fields : ["id","rolename"]
			})
});

Ynzc.manage.ShowRoleStore = new Ext.data.Store( {
	url : 'main/role.html?action=getAllShowRole',
	autoLoad:true,
	reader : new Ext.data.JsonReader({
				root : 'Role',
				id : 'role',
				fields : ["id","rolename"]
			})
});

Ynzc.manage.UnitStore = new Ext.data.Store({
	url:"main/unitManage.html?action=getAllUnit",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'Unit',
			id : 'unit',
			fields : ["id","useunit"]
		})
});
Ynzc.manage.PaleCodeUser=new Ext.data.Store({
	url:"main/user.html?action=getPalteCodeUser",
	autoLoad:false,
	reader : new Ext.data.JsonReader({
			root : 'PalteCodeUser',
			id : 'palteCodeUser',
			fields : ["id","realname"]
		})
}); 
Ynzc.manage.BusinessUser=new Ext.data.Store({
	url:"main/user.html?action=getBusinessUser",
	autoLoad:false,
	reader : new Ext.data.JsonReader({
			root : 'BusinessUser',
			id : 'businessUser',
			fields : ["id","realname"]
		})
}); 
Ynzc.manage.Certificate = new Ext.data.Store({
	url:"main/certificate.html?action=getAllCertificate",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'Certificate',
			id : 'certificate',
			fields : ["id","realcertificatetype"]
		})
});

Ynzc.manage.GetWay = new Ext.data.Store({
	url:"main/getWay.html?action=getAllGetWay",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'GetWay',
			id : 'getWay',
			fields : ["id","getway"]
		})
});

Ynzc.manage.ImportsFile = new Ext.data.Store({
	url:"main/importsFile.html?action=getAllImportsFile",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'ImportsFile',
			id : 'importsFile',
			fields : ["id","importsFileType"]
		})
});

Ynzc.manage.MachineType = new Ext.data.Store({
	url:"main/machineType.html?action=getAllMachineType",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'MachineType',
			id : 'machineType',
			fields : ["id","machinetype"]
		})
});

Ynzc.manage.TempliveFile = new Ext.data.Store({
	url:"main/templiveFile.html?action=getAllTempliveFile",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'TempliveFile',
			id : 'templiveFile',
			fields : ["id","templivefileType"]
		})
});
Ynzc.manage.WayFile = new Ext.data.Store({
	url:"main/wayFile.html?action=getAllWayFile",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'WayFile',
			id : 'wayFile',
			fields : ["id","getWayFileType"]
		})
});
Ynzc.manage.FuelType = new Ext.data.Store({
	url:"main/fuelType.html?action=getAllFuelType",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'FuelType',
			id : 'fuelType',
			fields : ["id","fuelname"]
		})
})

var YesOrNoData = [['是', 1], ['否', 0]]
Ynzc.manage.YesOrNoStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: YesOrNoData,
    autoload: true
});

var maintainData = [['未使用',0],['使用', 3],['补牌', 4],['报废', 5],['补换', 6],['已转移',7]]
Ynzc.manage.MaintainStore = new Ext.data.SimpleStore({
	fields:['displayvalue','value'],
	data:maintainData,
	autoload: true
});                    
var carCheckTypeData = [['年检', 0], ['脱检', 1]]
Ynzc.manage.CarCheckTypeData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: carCheckTypeData,
    autoload: true
});

var replaceTypeData = [['补领拖拉机牌', '补领拖拉机牌'], ['补领行驶证', '补领行驶证'], ['补领登记证书', '补领登记证书'], ['换拖拉机号牌', '换拖拉机号牌'], ['换行驶证', '换行驶证'], ['换领登记证书', '换领登记证书']]
Ynzc.manage.ReplaceTypeData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: replaceTypeData,
    autoload: true
});

var mortgageData = [['抵押登记', '抵押登记'], ['注销抵押登记', '注销抵押登记']]
Ynzc.manage.MortgageData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: mortgageData,
    autoload: true
});
var UOrPData = [['单位', 1], ['个人', 0]]
Ynzc.manage.UOrPStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: UOrPData,
    autoload: true
});

var UsedForData = [['农兼营', '农兼营'], ['农作', '农作']]
Ynzc.manage.UsedFor = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: UsedForData,
    autoload: true
});

var changetypeData = [['共同所有的拖拉机变更拖拉机所有人', '共同所有的拖拉机变更拖拉机所有人'], ['变更机身颜色', '变更机身颜色'], ['更换发动机', '更换发动机'], ['更换挂车', '更换挂车'],['更换机身(底盘)','更换机身(底盘)'],['更换整机','更换整机']]
Ynzc.manage.ChangeTypeStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: changetypeData,
    autoload: true
});
var logouttypeData = [['注销', '0'], ['停驶', '1'], ['复驶', '2']]
Ynzc.manage.LogouttypeData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: logouttypeData,
    autoload: true
});
var CheckVerdictData = [['合格','合格'],['不合格','不合格']]
Ynzc.manage.CheckVerdictStore = new Ext.data.SimpleStore({
	fields:['display','value'],
	data:CheckVerdictData,
	autoload: true
});
var transfertypeData = [['拖拉机在农机监理机构管辖区的转移登记', '管辖区的转移登记'], ['拖拉机转出农机监理机构管辖区的转移登记', '管辖区外的转移登记']]
Ynzc.manage.TransferTypeStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: transfertypeData,
    autoload: true
});

var DirectData = [['方向盘', '方向盘'], ['方向把', '方向把']]
Ynzc.manage.DirectStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: DirectData,
    autoload: true
});

var CylinderData =[["1",1],["2",2],["3",3],["4",4],["5",5],["6",6]]
Ynzc.manage.CylinderStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: CylinderData,
    autoload: true
});

Ynzc.manage.ValidateList = new Ext.data.Store( {
	url : 'main/validateList.html?action=getAllValidateList',
	autoLoad : false,
	reader : new Ext.data.JsonReader({
				root : 'ValidateList',
				id : 'validateList',
				fields : ["id","machineType"]
			})
});

var SexData = [['男', '男'], ['女', '女']]
Ynzc.manage.SexStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: SexData,
	autoload: true
});

var DegreeData = [['博士', '博士'], ['硕士', '硕士'],['本科', '本科'], ['高中', '高中'],['初中', '初中'], ['小学', '小学'],['其他', '其他']]
Ynzc.manage.DegreeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: DegreeData,
	autoload: true
});

var ExactitudeOrUnExactitudeData = [['正常', 1], ['异常', 0]]
Ynzc.manage.ExactitudeOrUnExactitudeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: ExactitudeOrUnExactitudeData,
	autoload: true
});

var EligibilityOrUnEligibilityData = [['合格', 1], ['不合格', 0]]
Ynzc.manage.EligibilityOrUnEligibilityStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: EligibilityOrUnEligibilityData,
	autoload: true
});

var AlloCateData= [['已分配', 1], ['未分配', 0]]
Ynzc.manage.AlloCateStore=new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: AlloCateData,
	autoload: true
});

var FosterTypeData = [['增驾', 1], ['初次申领', 0]]
Ynzc.manage.FosterTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: FosterTypeData,
	autoload: true
});

var ApplicationTypeData = [['G', 1], ['H', 2], ['GK', 3], ['HK', 4], ['K', 5], ['R', 6], ['S', 7], ['T', 8], ['RS', 9], ['RT', 10], ['RK', 11], ['KS', 12], ['RG', 13], ['ST', 14], ['GS', 15], ['GKR', 16], ['KGS', 17]]
Ynzc.manage.ApplicationTypeStore = new Ext.data.SimpleStore({
  	fields: ['display', 'value'],
  	data: ApplicationTypeData,
  	autoload: true
});

var ApplicationTypeNewData = [['G', 1], ['H', 2], ['K', 5], ['R', 6], ['S', 7], ['T', 8]]
Ynzc.manage.ApplicationTypeNewStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: ApplicationTypeNewData,
	autoload: true
});

var ApplicationTypeAgainData = [['GK', 3], ['HK', 4], ['RS', 9], ['RT', 10], ['RK', 11], ['KS', 12], ['RG', 13], ['ST', 14], ['GS', 15], ['GKR', 16], ['KGS', 17]]
Ynzc.manage.ApplicationTypeAgainStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: ApplicationTypeAgainData,
	autoload: true
});

var StrStateData = [['审核中', 0], ['审核通过', 1], ['已领技术准考证', 2],['已领技术准考证', 3],['理论通过', 4], ['理论未通过', 5],['技术通过', 6],['技术未通过', 7], ['发放驾驶证', 8]]
Ynzc.manage.StrStateStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: StrStateData,
	autoload: true
});

var ClassStateData = [['学员录入', 0], ['上报中', 1], ['审核通过', 2],['理论考试', 3], ['技术考试', 4], ['发放驾驶证', 5]]
Ynzc.manage.ClassStateStore = new Ext.data.SimpleStore({
  	fields: ['display', 'value'],
  	data: ClassStateData,
  	autoload: true
});

var PassData = [['同意', 1],['不同意', 0]]
Ynzc.manage.PassStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: PassData,
	autoload: true
});

var UseDrivingLincenceData = [['可用', 1],['不可用', 0]]
Ynzc.manage.UseDrivingLincenceStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: UseDrivingLincenceData,
	autoload: true
});

var FosterTypeData = [['新训', 1], ['增训', 2]]
Ynzc.manage.FosterTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: FosterTypeData,
	autoload: true
});

var ProveTypeData = [['身份证', 1], ['暂住证', 2]]
Ynzc.manage.ProveTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: ProveTypeData,
  	autoload: true
});

var DrivingLicenceDeclareStateData = [['未上报', 0],['审核中', 1], ['审核通过', 2], ['审核不通过', 3], ['已打印驾驶证', 4],['已归档', 5],['不归档', 6]]
Ynzc.manage.DrivingLicenceDeclareStateStore = new Ext.data.SimpleStore({
  	fields: ['display', 'value'],
  	data: DrivingLicenceDeclareStateData,
  	autoload: true
});

var DrivingLicenceDeclareTypeData = [['补证', 1], ['污损换证', 2], ['期满换证', 3],['信息变化', 4],['转入', 5],['转出', 6],['注销', 7]]
Ynzc.manage.DrivingLicenceDeclareTypeStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: DrivingLicenceDeclareTypeData,
    autoload: true
});

var OperationTypeData = [['信息变更', 1], ['驾照期满', 2], ['驾照污损', 3],['驾照补证', 4],['驾照转入', 5],['驾照转出', 6],['驾照注销', 7]]
Ynzc.manage.OperationTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: OperationTypeData,
	autoload: true
});

var OperationPutOutTypeData = [['信息变更打印', 1], ['驾照期满打印', 2], ['驾照污损打印', 3],['驾照补证打印', 4],['驾照转入打印', 5]]
Ynzc.manage.OperationPutOutTypeStore = new Ext.data.SimpleStore({
 	fields: ['display', 'value'],
 	data: OperationPutOutTypeData,
 	autoload: true
});

var UserStateData = [['可用', 1],['不可用', 2], ['已转出', 3], ['已注销', 4],['过期',5]]
Ynzc.manage.UserStateStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: UserStateData,
    autoload: true
});
var IsTempLiveData = [['暂住', 1],['常住', 2]]
Ynzc.manage.IsTempLiveData = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: IsTempLiveData,
    autoload: true
});
var BaoXianType = [['交强险', 1],['第三者责任险', 2]]
Ynzc.manage.BaoXianType = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: BaoXianType,
    autoload: true
});
var InsurceMark = [['初次年检', 1],['年检修改', 2]]
Ynzc.manage.InsurceMark = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: InsurceMark,
    autoload: true
});
var examResultData = [['及格', 1],['理论不及格', 2],['术科不及格', 3]]
Ynzc.manage.examResultStore = new Ext.data.SimpleStore({
       fields: ['display', 'value'],
       data: examResultData,
       autoload: true
});
var ApplicationDataType = [['由联合收割机所有人申请', 1],['联合收割机所有人委托代理申请', 2]]
Ynzc.manage.ApplicationDataType = new Ext.data.SimpleStore({
    fields: ['display', 'id'],
    data: ApplicationDataType,
    autoload: true
});
var carType = [['拖拉机', 1],['联合收割机', 2]]
Ynzc.manage.drivingType = new Ext.data.SimpleStore({
    fields: ['display', 'id'],
    data: carType,
    autoload: true
});
var uniteHarvestType = [['方向盘自走式联合收割机', 1],['操纵杆自走式联合收割机', 2],['悬挂式联合收割机', 3]]
Ynzc.manage.uniteHarvestType = new Ext.data.SimpleStore({
    fields: ['display', 'id'],
    data: uniteHarvestType,
    autoload: true
});
var filingData = [['注册登记','注册登记'],['车辆年检','车辆年检'],['共同所有的拖拉机变更拖拉机所有人', '共同所有的拖拉机变更拖拉机所有人'], ['变更机身颜色', '变更机身颜色'], ['更换发动机', '更换发动机'], ['更换挂车', '更换挂车'],['更换机身(底盘)','更换机身(底盘)'],['更换整机','更换整机'],['转移登记','转移登记'],['补领、补换牌证','补领、补换牌证'],['变更备案登记','变更备案登记'],['抵押登记','抵押登记'],['注销登记','注销登记']]
Ynzc.manage.filingStroe = new Ext.data.SimpleStore({
      fields: ['display', 'value'],
      data: filingData,
      autoload: true
});Ext.ns("Ynzc");
Ext.ns("Ynzc.manage");

Ynzc.manage.RoleStore = new Ext.data.Store( {
	url : 'main/role.html?action=getAllRole',
	autoLoad:true,
	reader : new Ext.data.JsonReader({
				root : 'Role',
				id : 'role',
				fields : ["id","rolename"]
			})
});

Ynzc.manage.ShowRoleStore = new Ext.data.Store( {
	url : 'main/role.html?action=getAllShowRole',
	autoLoad:true,
	reader : new Ext.data.JsonReader({
				root : 'Role',
				id : 'role',
				fields : ["id","rolename"]
			})
});

Ynzc.manage.UnitStore = new Ext.data.Store({
	url:"main/unitManage.html?action=getAllUnit",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'Unit',
			id : 'unit',
			fields : ["id","useunit"]
		})
});
Ynzc.manage.PaleCodeUser=new Ext.data.Store({
	url:"main/user.html?action=getPalteCodeUser",
	autoLoad:false,
	reader : new Ext.data.JsonReader({
			root : 'PalteCodeUser',
			id : 'palteCodeUser',
			fields : ["id","realname"]
		})
}); 
Ynzc.manage.BusinessUser=new Ext.data.Store({
	url:"main/user.html?action=getBusinessUser",
	autoLoad:false,
	reader : new Ext.data.JsonReader({
			root : 'BusinessUser',
			id : 'businessUser',
			fields : ["id","realname"]
		})
}); 
Ynzc.manage.Certificate = new Ext.data.Store({
	url:"main/certificate.html?action=getAllCertificate",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'Certificate',
			id : 'certificate',
			fields : ["id","realcertificatetype"]
		})
});

Ynzc.manage.GetWay = new Ext.data.Store({
	url:"main/getWay.html?action=getAllGetWay",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'GetWay',
			id : 'getWay',
			fields : ["id","getway"]
		})
});

Ynzc.manage.ImportsFile = new Ext.data.Store({
	url:"main/importsFile.html?action=getAllImportsFile",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'ImportsFile',
			id : 'importsFile',
			fields : ["id","importsFileType"]
		})
});

Ynzc.manage.MachineType = new Ext.data.Store({
	url:"main/machineType.html?action=getAllMachineType",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'MachineType',
			id : 'machineType',
			fields : ["id","machinetype"]
		})
});

Ynzc.manage.TempliveFile = new Ext.data.Store({
	url:"main/templiveFile.html?action=getAllTempliveFile",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'TempliveFile',
			id : 'templiveFile',
			fields : ["id","templivefileType"]
		})
});
Ynzc.manage.WayFile = new Ext.data.Store({
	url:"main/wayFile.html?action=getAllWayFile",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'WayFile',
			id : 'wayFile',
			fields : ["id","getWayFileType"]
		})
});
Ynzc.manage.FuelType = new Ext.data.Store({
	url:"main/fuelType.html?action=getAllFuelType",
	autoLoad:true,
	reader : new Ext.data.JsonReader({
			root : 'FuelType',
			id : 'fuelType',
			fields : ["id","fuelname"]
		})
})

var YesOrNoData = [['是', 1], ['否', 0]]
Ynzc.manage.YesOrNoStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: YesOrNoData,
    autoload: true
});

var maintainData = [['未使用',0],['使用', 3],['补牌', 4],['报废', 5],['补换', 6],['已转移',7]]
Ynzc.manage.MaintainStore = new Ext.data.SimpleStore({
	fields:['displayvalue','value'],
	data:maintainData,
	autoload: true
});                    
var carCheckTypeData = [['年检', 0], ['脱检', 1]]
Ynzc.manage.CarCheckTypeData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: carCheckTypeData,
    autoload: true
});

var replaceTypeData = [['补领拖拉机牌', '补领拖拉机牌'], ['补领行驶证', '补领行驶证'], ['补领登记证书', '补领登记证书'], ['换拖拉机号牌', '换拖拉机号牌'], ['换行驶证', '换行驶证'], ['换领登记证书', '换领登记证书']]
Ynzc.manage.ReplaceTypeData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: replaceTypeData,
    autoload: true
});

var mortgageData = [['抵押登记', '抵押登记'], ['注销抵押登记', '注销抵押登记']]
Ynzc.manage.MortgageData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: mortgageData,
    autoload: true
});
var UOrPData = [['单位', 1], ['个人', 0]]
Ynzc.manage.UOrPStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: UOrPData,
    autoload: true
});

var UsedForData = [['农兼营', '农兼营'], ['农作', '农作']]
Ynzc.manage.UsedFor = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: UsedForData,
    autoload: true
});

var changetypeData = [['共同所有的拖拉机变更拖拉机所有人', '共同所有的拖拉机变更拖拉机所有人'], ['变更机身颜色', '变更机身颜色'], ['更换发动机', '更换发动机'], ['更换挂车', '更换挂车'],['更换机身(底盘)','更换机身(底盘)'],['更换整机','更换整机']]
Ynzc.manage.ChangeTypeStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: changetypeData,
    autoload: true
});
var logouttypeData = [['注销', '0'], ['停驶', '1'], ['复驶', '2']]
Ynzc.manage.LogouttypeData = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: logouttypeData,
    autoload: true
});
var transfertypeData = [['拖拉机在农机监理机构管辖区的转移登记', '管辖区的转移登记'], ['拖拉机转出农机监理机构管辖区的转移登记', '管辖区外的转移登记']]
Ynzc.manage.TransferTypeStore = new Ext.data.SimpleStore({
    fields: ['displayvalue', 'value'],
    data: transfertypeData,
    autoload: true
});

var DirectData = [['方向盘', '方向盘'], ['方向把', '方向把']]
Ynzc.manage.DirectStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: DirectData,
    autoload: true
});

var CylinderData =[["1",1],["2",2],["3",3],["4",4],["5",5],["6",6]]
Ynzc.manage.CylinderStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: CylinderData,
    autoload: true
});

Ynzc.manage.ValidateList = new Ext.data.Store( {
	url : 'main/validateList.html?action=getAllValidateList',
	autoLoad : false,
	reader : new Ext.data.JsonReader({
				root : 'ValidateList',
				id : 'validateList',
				fields : ["id","machineType"]
			})
});

var SexData = [['男', '男'], ['女', '女']]
Ynzc.manage.SexStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: SexData,
	autoload: true
});

var DegreeData = [['博士', '博士'], ['硕士', '硕士'],['本科', '本科'], ['高中', '高中'],['初中', '初中'], ['小学', '小学'],['其他', '其他']]
Ynzc.manage.DegreeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: DegreeData,
	autoload: true
});

var ExactitudeOrUnExactitudeData = [['正常', 1], ['异常', 0]]
Ynzc.manage.ExactitudeOrUnExactitudeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: ExactitudeOrUnExactitudeData,
	autoload: true
});

var EligibilityOrUnEligibilityData = [['合格', 1], ['不合格', 0]]
Ynzc.manage.EligibilityOrUnEligibilityStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: EligibilityOrUnEligibilityData,
	autoload: true
});

var AlloCateData= [['已分配', 1], ['未分配', 0]]
Ynzc.manage.AlloCateStore=new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: AlloCateData,
	autoload: true
});

var FosterTypeData = [['增驾', 1], ['初次申领', 0]]
Ynzc.manage.FosterTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: FosterTypeData,
	autoload: true
});

var ApplicationTypeData = [['G', 1], ['H', 2], ['GK', 3], ['HK', 4], ['K', 5], ['R', 6], ['S', 7], ['T', 8], ['RS', 9], ['RT', 10], ['RK', 11], ['KS', 12], ['RG', 13], ['ST', 14], ['GS', 15], ['GKR', 16], ['KGS', 17]]
Ynzc.manage.ApplicationTypeStore = new Ext.data.SimpleStore({
  	fields: ['display', 'value'],
  	data: ApplicationTypeData,
  	autoload: true
});

var StrStateData = [['审核中', 0], ['审核通过', 1], ['已领技术准考证', 2],['已领技术准考证', 3],['理论通过', 4], ['理论未通过', 5],['技术通过', 6],['技术未通过', 7], ['发放驾驶证', 8],['退回修改',9],['修改上报',10]]
Ynzc.manage.StrStateStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: StrStateData,
	autoload: true
});

var ClassStateData = [['学员录入', 0], ['上报中', 1], ['审核通过', 2],['理论考试', 3], ['技术考试', 4], ['发放驾驶证', 5]]
Ynzc.manage.ClassStateStore = new Ext.data.SimpleStore({
  	fields: ['display', 'value'],
  	data: ClassStateData,
  	autoload: true
});

var PassData = [['同意', 1],['不同意', 0]]
Ynzc.manage.PassStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: PassData,
	autoload: true
});

var UseDrivingLincenceData = [['可用', 1],['不可用', 0]]
Ynzc.manage.UseDrivingLincenceStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: UseDrivingLincenceData,
	autoload: true
});

var FosterTypeData = [['新训', 1], ['增训', 2]]
Ynzc.manage.FosterTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: FosterTypeData,
	autoload: true
});

var ProveTypeData = [['身份证', 1], ['暂住证', 2]]
Ynzc.manage.ProveTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: ProveTypeData,
  	autoload: true
});

var DrivingLicenceDeclareStateData = [['未上报', 0],['审核中', 1], ['审核通过', 2], ['审核不通过', 3], ['已打印驾驶证', 4],['已归档', 5],['不归档', 6]]
Ynzc.manage.DrivingLicenceDeclareStateStore = new Ext.data.SimpleStore({
  	fields: ['display', 'value'],
  	data: DrivingLicenceDeclareStateData,
  	autoload: true
});

var DrivingLicenceDeclareTypeData = [['补证', 1], ['污损换证', 2], ['期满换证', 3],['信息变化', 4],['转入', 5],['转出', 6],['注销', 7]]
Ynzc.manage.DrivingLicenceDeclareTypeStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: DrivingLicenceDeclareTypeData,
    autoload: true
});

var OperationTypeData = [['信息变更', 1], ['驾照期满', 2], ['驾照污损', 3],['驾照补证', 4],['驾照转入', 5],['驾照转出', 6],['驾照注销', 7]]
Ynzc.manage.OperationTypeStore = new Ext.data.SimpleStore({
	fields: ['display', 'value'],
	data: OperationTypeData,
	autoload: true
});

var OperationPutOutTypeData = [['信息变更打印', 1], ['驾照期满打印', 2], ['驾照污损打印', 3],['驾照补证打印', 4],['驾照转入打印', 5]]
Ynzc.manage.OperationPutOutTypeStore = new Ext.data.SimpleStore({
 	fields: ['display', 'value'],
 	data: OperationPutOutTypeData,
 	autoload: true
});

var UserStateData = [['可用', 1],['不可用', 2], ['已转出', 3], ['已注销', 4]]
Ynzc.manage.UserStateStore = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: UserStateData,
    autoload: true
});
var IsTempLiveData = [['暂住', 1],['常住', 2]]
Ynzc.manage.IsTempLiveData = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: IsTempLiveData,
    autoload: true
});
var BaoXianType = [['交强险', 1],['第三者责任险', 2]]
Ynzc.manage.BaoXianType = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: BaoXianType,
    autoload: true
});
var InsurceMark = [['初次年检', 1],['年检修改', 2]]
Ynzc.manage.InsurceMark = new Ext.data.SimpleStore({
    fields: ['display', 'value'],
    data: InsurceMark,
    autoload: true
});
var examResultData = [['及格', 1],['理论不及格', 2],['术科不及格', 3]]
Ynzc.manage.examResultStore = new Ext.data.SimpleStore({
       fields: ['display', 'value'],
       data: examResultData,
       autoload: true
});
var ApplicationDataType = [['由联合收割机所有人申请', 1],['联合收割机所有人委托代理申请', 2]]
Ynzc.manage.ApplicationDataType = new Ext.data.SimpleStore({
    fields: ['display', 'id'],
    data: ApplicationDataType,
    autoload: true
});
var carType = [['拖拉机', 1],['联合收割机', 2]]
Ynzc.manage.drivingType = new Ext.data.SimpleStore({
    fields: ['display', 'id'],
    data: carType,
    autoload: true
});
var uniteHarvestType = [['方向盘自走式联合收割机', 1],['操纵杆自走式联合收割机', 2],['悬挂式联合收割机', 3]]
Ynzc.manage.uniteHarvestType = new Ext.data.SimpleStore({
    fields: ['display', 'id'],
    data: uniteHarvestType,
    autoload: true
});
var filingData = [['注册登记','注册登记'],['车辆年检','车辆年检'],['共同所有的拖拉机变更拖拉机所有人', '共同所有的拖拉机变更拖拉机所有人'], ['变更机身颜色', '变更机身颜色'], ['更换发动机', '更换发动机'], ['更换挂车', '更换挂车'],['更换机身(底盘)','更换机身(底盘)'],['更换整机','更换整机'],['转移登记','转移登记'],['补领、补换牌证','补领、补换牌证'],['变更备案登记','变更备案登记'],['抵押登记','抵押登记'],['注销登记','注销登记']]
Ynzc.manage.filingStroe = new Ext.data.SimpleStore({
      fields: ['display', 'value'],
      data: filingData,
      autoload: true
});

Ynzc.manage.RegisterYearStroe = new Ext.data.Store( {
	url : 'main/tractorInfo.html?action=getRegisterYear',
	autoLoad:true,
	reader : new Ext.data.JsonReader({
				root : 'RegisterYear',
				id : 'registerYear',
				fields : ["myyear"]
			})
});