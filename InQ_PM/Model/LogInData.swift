//
//  LogInData.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import Foundation

struct Login : Encodable {
    let loginId : String
    let pw : String
}

struct Member : Encodable {
    let loginId : String
    let pw : String
    let name : String
    let position : String
    var techList : String
}



