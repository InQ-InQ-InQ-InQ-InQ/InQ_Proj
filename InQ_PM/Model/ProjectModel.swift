//
//  ProjectData.swift
//  InQ_PM
//
//  Created by RooZin on 2022/01/27.
//

import Foundation

struct ProjectData : Codable {
    let id : Int?
    let projectName : String?
    let state : String?
    let details : String?
    let techList : String?
    
    init(id : Int, projectName : String, state : String, details : String, techList : String) {
        self.id = id
        self.projectName = projectName
        self.state = state
        self.details = details
        self.techList = techList
    }
}
