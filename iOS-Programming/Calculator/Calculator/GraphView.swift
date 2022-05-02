//
//  GraphView.swift
//  Calculator
//
//  Created by raidi01 on 3/15/16.
//  Copyright © 2016 Luther College. All rights reserved.
//

import UIKit
//GraphViewDataSource can only be used by class
protocol GraphViewDataSource: class{
    func y(x:CGFloat) -> CGFloat?
}
@IBDesignable //making properties be editable using inspectable gui
class GraphView: UIView {
    weak var dataSource: GraphViewDataSource?
    
    @IBInspectable
    var scale: CGFloat = 50.0{
        didSet{
            setNeedsDisplay()
        }
    }
    
    @IBInspectable
    var origin: CGPoint = CGPoint(){
        didSet{
            resetOrigin = false
            setNeedsDisplay()
        }
    }
    @IBInspectable
    var lineWidth: CGFloat = 1.0{
        didSet{
            setNeedsDisplay()
        }
    }
    @IBInspectable
    var color: UIColor = UIColor.blackColor(){
        didSet{
            setNeedsDisplay()
        }
    }
    @IBInspectable
    private var resetOrigin: Bool = true{
        didSet{
            if resetOrigin{
                setNeedsDisplay()
            }
        }
    }
    
    override func drawRect(rect: CGRect) {
        if resetOrigin{
            origin = center
        }
        AxesDrawer(contentScaleFactor: contentScaleFactor).drawAxesInRect(bounds, origin: origin, pointsPerUnit: scale)
    
        color.set()
        let path = UIBezierPath()
        path.lineWidth = lineWidth
        var firstValue = true
        
        var point = CGPoint()
        
        for var i = 0; i <= Int(bounds.size.width * contentScaleFactor); i++ {
            point.x = CGFloat(i) / contentScaleFactor
            if let y = dataSource?.y((point.y - origin.x)/scale){
                if !y.isNormal && !y.isZero {
                    firstValue = true
                    continue
                }
                point.y = origin.y - y*scale
                if firstValue{
                    path.addLineToPoint(point)
                    firstValue = false
                }else{
                    path.addLineToPoint(point)
                }
            }else{
                firstValue = true
            }
        }
        path.stroke()
        
    }
    
    func zoom(gesture: UIPinchGestureRecognizer){
        if gesture.state == .Changed{
            scale *= gesture.scale
            gesture.scale = 1.0
        }
    }
    func move(gesture: UIPanGestureRecognizer){
        switch gesture.state{
        case .Ended: fallthrough
        case .Changed:
            let translation = gesture.translationInView(self)
            origin.x += translation.x
            origin.y += translation.y
            
            gesture.setTranslation(CGPointZero, inView: self)
        default: break
        }
    }
    func center(gesture: UITapGestureRecognizer){
        if gesture.state == .Ended{
            origin = gesture.locationInView(self)
        }
    }
    

}
