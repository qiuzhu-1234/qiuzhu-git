const base = {
    get() {
        return {
            url : "http://localhost:8080/hrms/",
            name: "hrms",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "比特人事管理系统"
        } 
    }
}
export default base
