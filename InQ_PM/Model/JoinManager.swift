//
//  JoinManager.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import Foundation
import Alamofire

protocol JoinManagerDelegate {
    func joinCheck(_ data : Check)
}

class JoinManager {
    
    var delegate : JoinManagerDelegate?
    
    func join(_ id : String, _ pw : String, _ name : String, _ position : String, _ techList : String) {
        let URL = "https://1af1-115-143-100-251.ngrok.io/members/join"
        let param = Member(loginId: id, pw: pw, name: name, position: position, techList: techList)
        
        AF.request(URL, method: .post, parameters: param).responseJSON { response in
            print("response: \(response)")
            var pass : Check
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    pass = try decoder.decode(Check.self, from: response.data!)
                    self.delegate?.joinCheck(pass)
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
