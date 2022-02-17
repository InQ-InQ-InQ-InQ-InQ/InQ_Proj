//
//  JoinProjectManager.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import Foundation
import Alamofire

protocol JoinProjectDelegate {
    func joinProject(_ data : ProjectOrigin)
}

struct JoinProjectManager {
    
    var delegate : JoinProjectDelegate?
    
    func findProjectId(_ projectId : String) {
        let URL = "https://61ed-115-143-100-251.ngrok.io/projects"
        AF.request(URL, method: .get).responseJSON { response in
            print("상태: \(response)")
            var project : [ProjectOrigin]
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    project = try decoder.decode([ProjectOrigin].self, from: response.data!)
                    for i in 0 ..< project.count {
                        if projectId == project[i].projectName {
                            print("선택한 프로젝트 : \(project[i])")
                            delegate?.joinProject(project[i])
                        }
                    }
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
