//
//  ProjectManager.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import Foundation
import Alamofire

protocol ProjectManagerDelegate {
    func updateProjectList(_ data : [ProjectData])
}

struct ProjectManager {
    
    var delegate : ProjectManagerDelegate?
    
    func loadProjectList() {
        let URL = "https://1af1-115-143-100-251.ngrok.io/projects"
   
        AF.request(URL, method: .get).responseJSON { response in
            print("response: \(response)")
            var project : [ProjectData]
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    project = try decoder.decode([ProjectData].self, from: response.data!)
                    delegate?.updateProjectList(project)
                case .failure(let error):
                    print("errorCode: \(error._code)")
                    print("errorDescription: \(error.errorDescription!)")
                }
            } catch let parsingError {
                print("Error : ", parsingError)
            }
        }.resume()
    }
    
    func filteringProject(_ state : String) {
        let URL = "https://1af1-115-143-100-251.ngrok.io/projects"
   
        AF.request(URL, method: .get).responseJSON { response in
            print("response: \(response)")
            var filtered : [ProjectData] = []
            var project : [ProjectData]
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    project = try decoder.decode([ProjectData].self, from: response.data!)
                    for i in 0 ..< project.count {
                        if (project[i].state == state) {
                            filtered.append(project[i])
                        }
                    }
                    delegate?.updateProjectList(filtered)
                case .failure(let error):
                    print("errorCode: \(error._code)")
                    print("errorDescription: \(error.errorDescription!)")
                }
            } catch let parsingError {
                print("Error : ", parsingError)
            }
        }.resume()
    }
    
    func loadMyProject() {
        let URL = "https://1af1-115-143-100-251.ngrok.io/members/joining-projects/my"
   
        AF.request(URL, method: .get).responseJSON { response in
            print("내 프로젝트: \(response)")
            var project : [ProjectData]
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    project = try decoder.decode([ProjectData].self, from: response.data!)
                    delegate?.updateProjectList(project)
                case .failure(let error):
                    print("errorCode: \(error._code)")
                    print("errorDescription: \(error.errorDescription!)")
                }
            } catch let parsingError {
                print("Error : ", parsingError)
            }
        }.resume()
    }
    
}
