//
//  CheckModel.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import Foundation

struct Check : Codable {
    let success : Bool?
    
    init(success: Bool) {
        self.success = success
    }
}
