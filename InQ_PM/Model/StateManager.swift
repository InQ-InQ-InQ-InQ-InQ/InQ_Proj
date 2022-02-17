//
//  StateManager.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/17.
//

import Foundation
import Alamofire

protocol StateManagerDelegate {
    func stateCheck(_ data : Check)
}

struct StateManager {
    
    var delegate : StateManagerDelegate?
    
    func changeProjectState(_ data : ProjectData, _ state : String) {
        let URL = "https://1af1-115-143-100-251.ngrok.io/projects/edit-state?state=\(state)"
        
        AF.request(URL, method: .post, parameters: data).responseJSON { response in
            print("상태 확인!: \(response)")
            var pass : Check
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    pass = try decoder.decode(Check.self, from: response.data!)
                    print("패스값 : \(pass)")
                    delegate?.stateCheck(pass)
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
