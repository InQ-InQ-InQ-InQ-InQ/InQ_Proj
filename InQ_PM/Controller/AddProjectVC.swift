//
//  AddProjectVC.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/16.
//

import UIKit
import Alamofire

class AddProjectVC: UIViewController {
    
    var projectManager = ProjectManager()
    var projectData : [ProjectData] = []
    
    @IBOutlet weak var projectID: UITextField!
    @IBOutlet weak var detail: UITextField!
    @IBOutlet weak var techList: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        projectManager.delegate = self
        // Do any additional setup after loading the view.
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?){ // 키보드 내리기
        self.view.endEditing(true)
    }
    
    @IBAction func addProject(_ sender: UIButton) {
        
        let URL = "https://1af1-115-143-100-251.ngrok.io/projects/add"
        
        let param = ProjectData(id: projectData.count + 1, projectName: projectID.text!, state: "RECRUIT", details: detail.text!, techList: techList.text!)
        
        AF.request(URL, method: .post, parameters: param).responseJSON { response in
            print("response: \(response)")
            var pass : Check
            do {
                let decoder = JSONDecoder()
                switch (response.result) {
                case .success:
                    pass = try decoder.decode(Check.self, from: response.data!)
                    if pass.success! == true {
                        let alert = UIAlertController(title: "🎉🎉🎉", message: "프로젝트 등록이 완료되었습니다.", preferredStyle: UIAlertController.Style.alert)
                        let okAction = UIAlertAction(title: "OK", style: .default) { (action) in
                            self.presentingViewController?.dismiss(animated: true, completion: nil)
                        }
                        alert.addAction(okAction)
                        self.present(alert, animated: false, completion: nil)
                    }
                    else {
                        let alert = UIAlertController(title: "등록실패", message: "프로젝트 정보를 다시 입력해주세요", preferredStyle: UIAlertController.Style.alert)
                        let okAction = UIAlertAction(title: "OK", style: .default) { (action) in }
                        alert.addAction(okAction)
                        self.present(alert, animated: false, completion: nil)
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

extension AddProjectVC : ProjectManagerDelegate {
    func updateProjectList(_ data: [ProjectData]) {
        projectData = data
    }
    
    
}
