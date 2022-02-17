//
//  MyProjectVC.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/17.
//

import UIKit

class MyProjectVC: UIViewController {
    
    var homeManager = HomeVC()
    var stateManager = StateManager()
    
    var myProjectData : ProjectData?
    
    @IBOutlet weak var projectTitle: UILabel!
    @IBOutlet weak var projectDetail: UILabel!
    @IBOutlet weak var projectTech: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        homeManager.projectStateDelegate = self
        stateManager.delegate = self
        projectTitle.text = myProjectData?.projectName
        projectDetail.text = myProjectData?.details
        projectTech.text = myProjectData?.techList
        // Do any additional setup after loading the view.
    }
    
    @IBAction func pressING(_ sender: UIButton) {
        stateManager.changeProjectState(myProjectData!, "ING")
    }
    
    
    @IBAction func pressRECRUIT(_ sender: UIButton) {
        stateManager.changeProjectState(myProjectData!, "RECRUIT")
    }
    
    @IBAction func pressFIN(_ sender: Any) {
        stateManager.changeProjectState(myProjectData!, "FIN")
    }

}

extension MyProjectVC : ProjectStateDelegate {
    func changeState(_ data: ProjectData) {
        myProjectData = data
    }
}

extension MyProjectVC : StateManagerDelegate {
    func stateCheck(_ data: Check) {
        if data.success! == true {
            let alert = UIAlertController(title: "🎉🎉🎉", message: "상태변경 완료", preferredStyle: UIAlertController.Style.alert)
            let okAction = UIAlertAction(title: "OK", style: .default) { (action) in
                self.presentingViewController?.dismiss(animated: true, completion: nil)
            }
            alert.addAction(okAction)
            present(alert, animated: false, completion: nil)
        }
        else {
            let alert = UIAlertController(title: "☹️☹️☹️", message: "상태변경에 실패하였습니다", preferredStyle: UIAlertController.Style.alert)
            let okAction = UIAlertAction(title: "OK", style: .default) { (action) in }
            alert.addAction(okAction)
            present(alert, animated: false, completion: nil)
        }
    }
    
    
}

