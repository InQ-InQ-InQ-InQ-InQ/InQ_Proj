//
//  MemberModel.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import Foundation

struct MemberData : Codable {
    let loginId : String
    let pw : String
    let name : String
    let position : String
    let techList : String
    
    init(_ loginId : String, _ pw : String, _ name : String, _ position : String, _ techList : String) {
        self.loginId = loginId
        self.pw = pw
        self.name = name
        self.position = position
        self.techList = techList
    }
}

struct CurrentMember {
    let name : String
    let position : String
    let techList : String
    
    init(_ name : String, _ position : String, _ techList : String) {
        self.name = name
        self.position = position
        self.techList = techList
    }
}

