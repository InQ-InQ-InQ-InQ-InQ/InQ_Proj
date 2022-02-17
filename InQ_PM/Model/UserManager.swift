//
//  UserManager.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import Foundation
import Alamofire

protocol UserManagerDelegate {
    func adoptCurrentUser(_ user : MemberData)
}

struct UserManager {
    
    var delegate : UserManagerDelegate?
    public var current : MemberData?
    
    func getCurrentUser() {
        let URL = "https://1af1-115-143-100-251.ngrok.io/members/my-info"
        
        AF.request(URL, method: .get).responseJSON { response in
            print("response: \(response)")
            var user : MemberData
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    user = try decoder.decode(MemberData.self, from: response.data!)
                    delegate?.adoptCurrentUser(user)
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
